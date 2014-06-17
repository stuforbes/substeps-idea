package com.technophobia.substeps.psi.feature;

import com.intellij.psi.tree.IElementType;
import com.technophobia.substeps.language.feature.FeatureLanguage;
import com.technophobia.substeps.language.substepsdefinition.SubstepsDefinitionLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class FeatureTokenType extends IElementType {

    public FeatureTokenType(@NotNull @NonNls String debugName){
        super(debugName, FeatureLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "FeatureTokenType."+super.toString();
    }
}
