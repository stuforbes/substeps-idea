package com.technophobia.substeps.psi.feature;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.technophobia.substeps.language.feature.FeatureFileType;
import com.technophobia.substeps.language.feature.FeatureLanguage;
import org.jetbrains.annotations.NotNull;

public class FeatureFile extends PsiFileBase {

    public FeatureFile(@NotNull FileViewProvider viewProvider){
        super(viewProvider, FeatureLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return FeatureFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Feature file";
    }
}