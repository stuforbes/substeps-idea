package com.technophobia.substeps.language.feature;

import com.intellij.lang.Language;

public class FeatureLanguage extends Language{

    public static final FeatureLanguage INSTANCE = new FeatureLanguage();

    private FeatureLanguage(){
        super("Feature");
    }
}
