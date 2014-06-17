package com.technophobia.substeps.language.feature;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.technophobia.substeps.language.SubstepsIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class FeatureFileType extends LanguageFileType {
    public static final FeatureFileType INSTANCE = new FeatureFileType();

    private FeatureFileType(){
        super(FeatureLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName(){
        return "Feature file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Feature file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "feature";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return SubstepsIcons.FILE;
    }
}
