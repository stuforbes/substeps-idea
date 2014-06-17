package com.technophobia.substeps.psi.substepsdefinition;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.technophobia.substeps.language.substepsdefinition.SubstepsDefinitionFileType;
import com.technophobia.substeps.language.substepsdefinition.SubstepsDefinitionLanguage;
import org.jetbrains.annotations.NotNull;

public class SubstepsDefinitionFile extends PsiFileBase {

    public SubstepsDefinitionFile(@NotNull FileViewProvider viewProvider){
        super(viewProvider, SubstepsDefinitionLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return SubstepsDefinitionFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Substeps file";
    }
}
