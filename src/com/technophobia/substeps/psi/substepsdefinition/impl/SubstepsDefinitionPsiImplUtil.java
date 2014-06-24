package com.technophobia.substeps.psi.substepsdefinition.impl;

import com.google.common.base.Function;
import com.intellij.openapi.project.ProjectManager;
import com.technophobia.substeps.model.Patterned;
import com.technophobia.substeps.model.SubstepsModel;
import generated.psi.SubstepsDefinitionStepLine;

public class SubstepsDefinitionPsiImplUtil {

    public static String definitionForStepText(final SubstepsDefinitionStepLine stepDefinitionLine){

        final String text = stepDefinitionLine.getText();

        return SubstepsModel.INSTANCE.findMatchingDefinitionsFor(ProjectManager.getInstance().getDefaultProject(), text).transform(patternToString()).or("unknown");
    }

    private static Function<Patterned, String> patternToString() {
        return new Function<Patterned, String>() {
            @Override
            public String apply(final Patterned patterned) {
                return patterned.pattern();
            }
        };
    }
}
