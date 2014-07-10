package com.technophobia.substeps.psi.substepsdefinition;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import com.technophobia.substeps.language.SubstepsFileType;
import generated.psi.SubstepsDefinitionDefinition;
import generated.psi.SubstepsDefinitionDefinitionTextBlock;

public class SubstepsDefinitionElementFactory {

    private static final String DEFINE_LABEL = "Define: ";

    public static SubstepsDefinitionDefinitionTextBlock createDefinition(final Project project, final String definitionText){
        final SubstepsDefinitionFile file = createFile(project, DEFINE_LABEL +definitionText);

        SubstepsDefinitionDefinition definition = (SubstepsDefinitionDefinition) file.getFirstChild();
        return definition.getDefinitionTextBlock();
    }

    private static SubstepsDefinitionFile createFile(final Project project, final String definitionText) {
        final String filename = "dummy.substeps";
        return (SubstepsDefinitionFile) PsiFileFactory.getInstance(project).createFileFromText(filename, SubstepsFileType.INSTANCE, definitionText);
    }
}