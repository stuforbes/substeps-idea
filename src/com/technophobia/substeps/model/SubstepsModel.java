package com.technophobia.substeps.model;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.Lists;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.roots.ProjectRootManager;
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
import com.technophobia.substeps.psi.substepsdefinition.SubstepsDefinitionFile;
import com.technophobia.substeps.runner.runtime.ClassLocator;
import com.technophobia.substeps.runner.runtime.StepClassLocator;
import com.technophobia.substeps.runner.syntax.SyntaxBuilder;
import generated.psi.SubstepsDefinitionDefinition;

import java.util.*;

public class SubstepsModel {

    private final List<SubstepDefinitions> definitions;

    private final List<VirtualFile> substepsFiles;

    public SubstepsModel() {
        this.substepsFiles = Collections.emptyList();
        this.definitions = Lists.newArrayList();

    }

    public void findMatchingDefinitionsFor(Project project, String text){
        if(definitions.isEmpty()){
            loadDefinitions(project);
        }
    }

    private void loadDefinitions(final Project project) {
        final List<VirtualFile> virtualFiles = substepsFiles;
        for(final VirtualFile virtualFile : virtualFiles){
            SubstepsDefinitionFile substepsFile = (SubstepsDefinitionFile) PsiManager.getInstance(project).findFile(virtualFile);

            final List<Class<?>> stepImplementationClasses = findStepImplementationClassesIn(project);

            SubstepsDefinitionDefinition[] definitions = PsiTreeUtil.getChildrenOfType(substepsFile, SubstepsDefinitionDefinition.class);
            for(SubstepsDefinitionDefinition definition : definitions){
//                this.definitions.add(new SubstepDefinitions(definition.getDefinitionText(), virtualFile.getPresentableUrl(), definition.))

            }
        }
    }

    private List<Class<?>> findStepImplementationClassesIn(final Project project) {
        GlobalSearchScope scope = GlobalSearchScope.allScope(project);
        PsiClass psiClass = JavaPsiFacade.getInstance(project).findClass("com.technophobia.substeps.model.SubSteps.AdditionalStepImplemnetations", scope);
        PsiClass psiClass2 = JavaPsiFacade.getInstance(project).findClass("com.technophobia.substeps.model.SubSteps.Step", scope);

        final List<String> classNames = new ArrayList<String>();
        Query<PsiMember> query = AnnotatedMembersSearch.search(psiClass, GlobalSearchScope.allScope(project));
        query.forEach(new Processor<PsiMember>() {
            public boolean process(PsiMember psiMember) {
                PsiClass container = psiMember.getContainingClass();
                String classname = container.getName();
                        classNames.add(classname + "." + psiMember.getName());
                return true;
            }
        });

        return Lists.transform(classNames, new Function<String, Class<?>>(){

            @Override
            public Class<?> apply(String s) {
                try {
                    return Class.forName(s);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });

    }


}
