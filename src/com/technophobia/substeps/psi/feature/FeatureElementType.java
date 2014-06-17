package com.technophobia.substeps.psi.feature;

import com.intellij.psi.tree.IElementType;
import com.technophobia.substeps.language.feature.FeatureLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class FeatureElementType extends IElementType {

    public FeatureElementType(@NotNull @NonNls String debugName){
        super(debugName, FeatureLanguage.INSTANCE);
    }
}

