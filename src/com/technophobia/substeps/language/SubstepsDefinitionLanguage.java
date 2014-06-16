package com.technophobia.substeps.language;

import com.intellij.lang.Language;

public class SubstepsDefinitionLanguage extends Language{

    public static final SubstepsDefinitionLanguage INSTANCE = new SubstepsDefinitionLanguage();

    private SubstepsDefinitionLanguage(){
        super("Substeps");
    }
}
