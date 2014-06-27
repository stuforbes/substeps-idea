package com.technophobia.substeps.psi.feature.impl;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.util.Pair;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceService;
import com.intellij.psi.tree.IElementType;
import com.technophobia.substeps.model.PatternIdentifiedPsiElement;
import com.technophobia.substeps.model.SubstepsModel;
import com.technophobia.substeps.psi.feature.FeatureElementFactory;
import com.technophobia.substeps.psi.feature.FeatureTypes;
import com.technophobia.substeps.psi.feature.ScenarioElement;
import generated.psi.FeatureScenario;
import generated.psi.FeatureScenarioOutline;

public class FeaturePsiImplUtil {


    /**
     * Scenario or Scenario outline element utility methods
     */

    public static String scenarioText(final ScenarioElement scenarioElement){
        Optional<ASTNode> scenarioTextNode = scenarioTextFor(scenarioElement);
        if(scenarioTextNode.isPresent()){
            return scenarioTextNode.get().getText();
        }
        return null;
    }

    public static String getName(final ScenarioElement scenarioElement){
        return scenarioText(scenarioElement);
    }

    public static PsiElement setName(ScenarioElement element, String newName){
        final Optional<ASTNode> textNode = scenarioTextFor(element);
        if(textNode.isPresent()){
            Optional<Pair<IElementType, IElementType>> labelAndTextType = labelAndTextTypesFor(element);
            if(labelAndTextType.isPresent()){
                final ScenarioElement newElement = FeatureElementFactory.createScenarioElement(element.getProject(), labelAndTextType.get().getFirst(), newName);
                final ASTNode newTextNode = newElement.getNode().findChildByType(labelAndTextType.get().getSecond());
                if(newTextNode != null){
                    element.getNode().replaceChild(textNode.get(), newTextNode);
                }
            }
        }
        return element;
    }

    public static PsiElement getNameIdentifier(final ScenarioElement scenario){
        Optional<Pair<IElementType, IElementType>> labelAndTextType = labelAndTextTypesFor(scenario);
        if(labelAndTextType.isPresent()) {
            ASTNode textNode = scenario.getNode().findChildByType(labelAndTextType.get().getSecond());
            return textNode != null ? textNode.getPsi() : null;
        }

        return null;
    }


    /**
     * Step line utility methods
     */

    public static String definitionForStepText(final PsiElement stepDefinitionLine){

        final String text = stepDefinitionLine.getText();

        return SubstepsModel.INSTANCE.findMatchingDefinitionsFor(ProjectManager.getInstance().getDefaultProject(), text).transform(patternToString()).or("unknown");
    }

    public static PsiReference[] getReferences(final PsiElement stepLine){
        return PsiReferenceService.getService().getContributedReferences(stepLine);
    }


    private static Optional<ASTNode> scenarioTextFor(final ScenarioElement scenarioElement) {
        ASTNode node = scenarioElement.getNode();

        return Optional.fromNullable(node.findChildByType(FeatureTypes.SCENARIO_TEXT))
                .or(Optional.fromNullable(node.findChildByType(FeatureTypes.SCENARIO_OUTLINE_TEXT)));
    }

    private static Optional<Pair<IElementType, IElementType>> labelAndTextTypesFor(final ScenarioElement scenarioElement){
        if(scenarioElement instanceof FeatureScenario){
            return Optional.of(new Pair<IElementType, IElementType>(FeatureTypes.SCENARIO_LABEL, FeatureTypes.SCENARIO_TEXT));
        } else if(scenarioElement instanceof FeatureScenarioOutline){
            return Optional.of(new Pair<IElementType, IElementType>(FeatureTypes.SCENARIO_OUTLINE_LABEL, FeatureTypes.SCENARIO_OUTLINE_TEXT));
        }
        return Optional.absent();
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
