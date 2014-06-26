package com.technophobia.substeps.reference.substepsdefinition;

import com.google.common.base.Optional;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.technophobia.substeps.language.SubstepsIcons;
import com.technophobia.substeps.model.PatternIdentifiedPsiElement;
import com.technophobia.substeps.search.substepsdefinition.SubstepDefinitionSearchUtil;
import generated.psi.SubstepsDefinitionDefinition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SubstepsDefinitionReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference{

    private final String stepText;

    public SubstepsDefinitionReference(@NotNull final PsiElement element, final TextRange textRange){
        super(element, textRange);

        System.out.println("step text: "+element.getText()+", text range: "+textRange);

        this.stepText = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        final Project project = myElement.getProject();
        Optional<PatternIdentifiedPsiElement> locatedDefinition = SubstepDefinitionSearchUtil.findDefinition(project, stepText);

        if(locatedDefinition.isPresent()){
            return new PsiElementResolveResult[]{new PsiElementResolveResult(locatedDefinition.get().target())};
        }
        return new ResolveResult[0];
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        Project project = myElement.getProject();
        List<PatternIdentifiedPsiElement> definitionsAndImpls = SubstepDefinitionSearchUtil.findDefinitions(project);
        List<LookupElement> variants = new ArrayList<LookupElement>();
        for (final PatternIdentifiedPsiElement  definitionsOrImpl : definitionsAndImpls) {
            PsiElement element = definitionsOrImpl.target();

            if(element instanceof SubstepsDefinitionDefinition) {
                SubstepsDefinitionDefinition definition = (SubstepsDefinitionDefinition) element;

                if (definition.definitionText() != null && definition.definitionText().length() > 0) {
                    variants.add(LookupElementBuilder.create(definition).
                                    withIcon(SubstepsIcons.FILE).
                                    withTypeText(definition.getContainingFile().getName())
                    );
                }
            } else if(element instanceof PsiMethod){
                PsiMethod method = (PsiMethod) element;

                variants.add(LookupElementBuilder.create(method, definitionsOrImpl.pattern())
                        .withIcon(SubstepsIcons.FILE)
                        .withTypeText(method.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }
}
