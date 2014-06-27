package com.technophobia.substeps.refactor.substepsdefinitions;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import generated.psi.SubstepsDefinitionDefinition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SubstepsDefinitionRefactoringSupportProvider extends RefactoringSupportProvider{

    @Override
    public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement element, @Nullable PsiElement context) {
        return element instanceof SubstepsDefinitionDefinition;
    }
}
