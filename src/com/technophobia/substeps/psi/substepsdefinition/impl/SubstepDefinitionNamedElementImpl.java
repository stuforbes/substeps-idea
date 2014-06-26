package com.technophobia.substeps.psi.substepsdefinition.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.technophobia.substeps.psi.substepsdefinition.SubstepDefinitionNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class SubstepDefinitionNamedElementImpl extends ASTWrapperPsiElement implements SubstepDefinitionNamedElement{
    public SubstepDefinitionNamedElementImpl(@NotNull ASTNode node){
        super(node);
    }
}
