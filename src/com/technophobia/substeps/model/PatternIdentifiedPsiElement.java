package com.technophobia.substeps.model;

import com.intellij.psi.PsiElement;

public interface PatternIdentifiedPsiElement {

    String pattern();

    PsiElement target();
}
