package com.technophobia.substeps.psi.substepsdefinition.impl;

import com.google.common.base.Function;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceService;
import com.technophobia.substeps.model.PatternIdentifiedPsiElement;
import com.technophobia.substeps.model.SubstepsModel;
import com.technophobia.substeps.psi.substepsdefinition.SubstepsDefinitionElementFactory;
import com.technophobia.substeps.psi.substepsdefinition.SubstepsDefinitionTypes;
import generated.psi.SubstepsDefinitionDefinition;
import generated.psi.SubstepsDefinitionStepLine;

public class SubstepsDefinitionPsiImplUtil {

    /**
     * Definition lines utility methods
     */

    /**
     * Finds the definition text node under the current definition line, and returns the text
     * @param definition The definition line
     * @return The text located in the definition text child element
     */
    public static String definitionText(final SubstepsDefinitionDefinition definition){
        ASTNode definitionTextNode = definition.getNode().findChildByType(SubstepsDefinitionTypes.DEFINITION_TEXT);
        if(definitionTextNode != null){
            return definitionTextNode.getText();
        }
        return null;
    }


    public static String getName(SubstepsDefinitionDefinition definition){
        return definitionText(definition);
    }

    public static PsiElement setName(SubstepsDefinitionDefinition definition, String newName){
        final ASTNode textNode = definition.getNode().findChildByType(SubstepsDefinitionTypes.DEFINITION_TEXT);
        if(textNode != null){

            final SubstepsDefinitionDefinition newDefinition = SubstepsDefinitionElementFactory.createDefinition(definition.getProject(), newName);
            final ASTNode newTextNode = newDefinition.getNode().findChildByType(SubstepsDefinitionTypes.DEFINITION_TEXT);
            if(newTextNode != null) {
                definition.getNode().replaceChild(textNode, newTextNode);
            }
        }
        return definition;
    }

    public static PsiElement getNameIdentifier(final SubstepsDefinitionDefinition definition){
        ASTNode textNode = definition.getNode().findChildByType(SubstepsDefinitionTypes.DEFINITION_TEXT);

        return textNode != null ? textNode.getPsi() : null;
    }

    /**
     * Step lines utility methods
     */

    /**
     * Needs work - currently takes the step text, and finds the matching step impl, substep definition, and returns the pattern
     * @param stepDefinitionLine The step line
     * @return The pattern that matches the step line
     */
    public static String definitionForStepText(final PsiElement stepDefinitionLine){

        final String text = stepDefinitionLine.getText();

        return SubstepsModel.INSTANCE.findMatchingDefinitionsFor(ProjectManager.getInstance().getDefaultProject(), text).transform(patternToString()).or("unknown");
    }

    public static PsiReference[] getReferences(final SubstepsDefinitionStepLine stepLine){
        return PsiReferenceService.getService().getContributedReferences(stepLine);
    }

    private static Function<PatternIdentifiedPsiElement, String> patternToString() {
        return new Function<PatternIdentifiedPsiElement, String>() {
            @Override
            public String apply(final PatternIdentifiedPsiElement patterned) {
                return patterned.pattern();
            }
        };
    }
}
