package com.technophobia.substeps.psi.substepsdefinition;

import com.intellij.psi.tree.IElementType;
import com.technophobia.substeps.language.substepsdefinition.SubstepsDefinitionLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SubstepsDefinitionTokenType extends IElementType {

    public SubstepsDefinitionTokenType(@NotNull @NonNls String debugName){
        super(debugName, SubstepsDefinitionLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "SubstepsTokenType."+super.toString();
    }
}
