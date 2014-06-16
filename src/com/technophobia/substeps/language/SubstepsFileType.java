package com.technophobia.substeps.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SubstepsFileType extends LanguageFileType {
    public static final SubstepsFileType INSTANCE = new SubstepsFileType();

    private SubstepsFileType(){
        super(SubstepsDefinitionLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName(){
        return "Substeps file";
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
