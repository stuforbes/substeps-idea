package com.technophobia.substeps.model;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.searches.AnnotatedMembersSearch;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.Processor;
import com.intellij.util.Query;
import com.intellij.util.indexing.FileBasedIndex;
import com.technophobia.substeps.language.substepsdefinition.SubstepsDefinitionFileType;
import com.technophobia.substeps.model.syntax.IdeaSyntax;
import com.technophobia.substeps.psi.substepsdefinition.SubstepsDefinitionFile;
import generated.psi.SubstepsDefinitionDefinition;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SubstepsModel {

    public static SubstepsModel INSTANCE = new SubstepsModel();

    private IdeaSyntax syntax = null;


    private SubstepsModel() {
    }

    public Optional<PatternIdentifiedPsiElement> findMatchingDefinitionsFor(final Project project, final String text) {
        final IdeaSyntax syntax = syntax(project);

        Optional<PatternIdentifiedPsiElement> substepImplementationModelOptional = syntax.stepImplementationMatching(text);
        Optional<PatternIdentifiedPsiElement> substepDefinitionModelOptional = syntax.substepDefinitionMatching(text);
        return substepDefinitionModelOptional.or(substepImplementationModelOptional);
    }

    public List<PatternIdentifiedPsiElement> allDefinitionsFor(final Project project){
        final IdeaSyntax syntax = syntax(project);

        final List<PatternIdentifiedPsiElement> results = Lists.newArrayList();
        results.addAll(syntax.allStepImplementations());
        results.addAll(syntax.allSubstepDefinitions());

        Collections.sort(results, new Comparator<PatternIdentifiedPsiElement>() {
            @Override
            public int compare(PatternIdentifiedPsiElement o1, PatternIdentifiedPsiElement o2) {
                return o1.pattern().compareTo(o2.pattern());
            }
        });
        return Collections.unmodifiableList(results);
    }

    private IdeaSyntax syntax(final Project project){
        if (syntax == null) {
            final List<SubstepDefinitionModel> definitionModels = loadDefinitions(project);
            final List<SubstepImplementationModel> implementationModels = loadImplementations(project);

            this.syntax = new IdeaSyntax(implementationModels, definitionModels);
        }
        return syntax;
    }

    private List<SubstepDefinitionModel> loadDefinitions(final Project project) {

        final Collection<VirtualFile> virtualFiles = substepsFiles(project);
        final List<SubstepDefinitionModel> definitionModels = Lists.newArrayList();

        for (final VirtualFile virtualFile : virtualFiles) {
            SubstepsDefinitionFile substepsFile = (SubstepsDefinitionFile) PsiManager.getInstance(project).findFile(virtualFile);

            SubstepsDefinitionDefinition[] definitions = PsiTreeUtil.getChildrenOfType(substepsFile, SubstepsDefinitionDefinition.class);
            if (definitions != null) {
                for (SubstepsDefinitionDefinition definition : definitions) {
                    String definitionText = definition.definitionText();
                    if(definitionText != null){
                        definitionModels.add(new SubstepDefinitionModel(definition, virtualFile.getPresentableUrl()));
                    }
                }
            }
        }
        return definitionModels;
    }

    private List<SubstepImplementationModel> loadImplementations(final Project project) {
        final List<SubstepImplementationModel> implementationModels = Lists.newArrayList();

        GlobalSearchScope scope = GlobalSearchScope.allScope(project);
        PsiClass stepAnnotationClass = JavaPsiFacade.getInstance(project).findClass("com.technophobia.substeps.model.SubSteps.Step", scope);
        PsiClass additionalStepImplAnnotationClass = JavaPsiFacade.getInstance(project).findClass("com.technophobia.substeps.model.SubSteps.AdditionalStepImplemnetations", scope);

        if (stepAnnotationClass != null) {
            Query<PsiMember> query = AnnotatedMembersSearch.search(stepAnnotationClass, GlobalSearchScope.allScope(project));
            query.forEach(new Processor<PsiMember>() {
                public boolean process(PsiMember psiMember) {
                    PsiClass container = psiMember.getContainingClass();
                    final Optional<String> stepText = stepTextFor(psiMember);
                    if (stepText.isPresent()) {
                        implementationModels.add(new SubstepImplementationModel(stepText.get(), container, psiMember.getName()));
                    }
                    return true;
                }
            });
        }

        return implementationModels;
    }

    private Optional<String> stepTextFor(final PsiMember psiMember) {
        final PsiModifierList modifierList = (PsiModifierList) psiMember.getFirstChild();
        final PsiAnnotation[] annotations = modifierList.getAnnotations();
        for (final PsiAnnotation annotation : annotations) {
            if ("com.technophobia.substeps.model.SubSteps.Step".equals(annotation.getQualifiedName())) {
                final PsiNameValuePair[] attributes = annotation.getParameterList().getAttributes();
                for (final PsiNameValuePair attribute : attributes) {
                    String name = attribute.getName();

                    // value is the implicit annotation parameter, so if the name is null, it must be value
                    if (name == null || "value".equals(name)) {
                        return Optional.of(dequote(attribute.getText()));
                    }
                }
            }
        }
        return Optional.absent();
    }

    private String dequote(String text) {
        return text.startsWith("\"") ? text.substring(1, text.length() - 1) : text;
    }

    private Collection<VirtualFile> substepsFiles(final Project project) {
        return FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, SubstepsDefinitionFileType.INSTANCE, GlobalSearchScope.allScope(project));
    }
}
