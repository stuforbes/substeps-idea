package com.technophobia.substeps.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.technophobia.substeps.language.SubstepsDefinitionLanguage;
import com.technophobia.substeps.language.SubstepsFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SubstepsDefinitionFile extends PsiFileBase {

    public SubstepsDefinitionFile(@NotNull FileViewProvider viewProvider){
        super(viewProvider, SubstepsDefinitionLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return SubstepsFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Substeps file";
    }
}
