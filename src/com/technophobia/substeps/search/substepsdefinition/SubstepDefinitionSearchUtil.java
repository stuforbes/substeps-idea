package com.technophobia.substeps.search.substepsdefinition;

import com.google.common.base.Optional;
import com.intellij.openapi.project.Project;
import com.technophobia.substeps.model.PatternIdentifiedPsiElement;
import com.technophobia.substeps.model.SubstepsModel;

import java.util.List;

public class SubstepDefinitionSearchUtil {

    public static Optional<PatternIdentifiedPsiElement> findDefinition(final Project project, final String text){

        return SubstepsModel.INSTANCE.findMatchingDefinitionsFor(project, text);
    }

    public static List<PatternIdentifiedPsiElement> findDefinitions(final Project project){

        return SubstepsModel.INSTANCE.allDefinitionsFor(project);
    }

}
