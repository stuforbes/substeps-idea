package com.technophobia.substeps.language.substepsdefinition;

import com.google.common.base.Supplier;
import com.intellij.lang.Language;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.indexing.FileBasedIndex;
import com.technophobia.substeps.model.SubstepsModel;

import java.util.List;

public class SubstepsDefinitionLanguage extends Language{

    public static final SubstepsDefinitionLanguage INSTANCE = new SubstepsDefinitionLanguage();

    private SubstepsDefinitionLanguage(){
        super("Substeps");
    }
}
