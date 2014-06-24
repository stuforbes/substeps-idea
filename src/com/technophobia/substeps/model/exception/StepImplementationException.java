package com.technophobia.substeps.model.exception;

import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiMethod;

public class StepImplementationException extends SubstepsException {

    private final PsiClass implementingClass;
    private final String implementingMethod;

    public StepImplementationException(final PsiClass implementingClass, final String implementingMethod,
                                       final String message) {
        super(message);
        this.implementingClass = implementingClass;
        this.implementingMethod = implementingMethod;
    }

    public PsiClass getImplementingClass() {
        return implementingClass;
    }

    public String getImplementingMethod() {
        return implementingMethod;
    }

}
