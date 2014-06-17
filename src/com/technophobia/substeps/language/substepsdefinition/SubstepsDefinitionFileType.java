package com.technophobia.substeps.language.substepsdefinition;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.technophobia.substeps.language.SubstepsIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SubstepsDefinitionFileType extends LanguageFileType {
    public static final SubstepsDefinitionFileType INSTANCE = new SubstepsDefinitionFileType();

    private SubstepsDefinitionFileType(){
        super(SubstepsDefinitionLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName(){
        return "Substeps definition file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Substeps definition file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "substeps";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return SubstepsIcons.FILE;
    }
}
