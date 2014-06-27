package com.technophobia.substeps.psi.feature;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.tree.IElementType;
import com.technophobia.substeps.language.SubstepsFileType;
import com.technophobia.substeps.language.feature.FeatureFileType;
import com.technophobia.substeps.psi.substepsdefinition.SubstepsDefinitionFile;
import generated.psi.SubstepsDefinitionDefinition;

public class FeatureElementFactory {

    private static final String SCENARIO_LABEL = "Scenario: ";
    private static final String SCENARIO_OUTLINE_LABEL = "Scenario Outline : ";

    public static ScenarioElement createScenarioElement(final Project project, final IElementType labelElementType, final String scenarioText){
        final FeatureFile file = createFile(project,  labelTextFor(labelElementType)+scenarioText);

        return (ScenarioElement)file.getFirstChild();
    }

    private static FeatureFile createFile(final Project project, final String scenarioText) {
        final String filename = "dummy.feature";
        return (FeatureFile) PsiFileFactory.getInstance(project).createFileFromText(filename, FeatureFileType.INSTANCE, scenarioText);
    }

    private static String labelTextFor(IElementType labelElementType) {
        return FeatureTypes.SCENARIO_LABEL.equals(labelElementType) ? SCENARIO_LABEL : SCENARIO_OUTLINE_LABEL;
    }
}