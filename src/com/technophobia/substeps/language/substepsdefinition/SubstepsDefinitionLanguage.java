package com.technophobia.substeps.language.substepsdefinition;

import com.intellij.lang.Language;

public class SubstepsDefinitionLanguage extends Language{

    public static final SubstepsDefinitionLanguage INSTANCE = new SubstepsDefinitionLanguage();

    private SubstepsDefinitionLanguage(){
        super("Substeps");
    }
}
