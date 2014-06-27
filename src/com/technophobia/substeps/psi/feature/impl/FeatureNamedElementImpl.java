package com.technophobia.substeps.psi.feature.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.technophobia.substeps.psi.feature.FeatureNamedElement;
import org.jetbrains.annotations.NotNull;

public class FeatureNamedElementImpl extends ASTWrapperPsiElement implements FeatureNamedElement{

    public FeatureNamedElementImpl(@NotNull final ASTNode node){
        super(node);
    }
}
