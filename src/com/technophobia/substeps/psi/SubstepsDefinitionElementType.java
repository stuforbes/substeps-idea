package com.technophobia.substeps.psi;

import com.intellij.psi.tree.IElementType;
import com.technophobia.substeps.language.SubstepsDefinitionLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SubstepsDefinitionElementType extends IElementType {

    public SubstepsDefinitionElementType(@NotNull @NonNls String debugName){
        super(debugName, SubstepsDefinitionLanguage.INSTANCE);
    }
}
