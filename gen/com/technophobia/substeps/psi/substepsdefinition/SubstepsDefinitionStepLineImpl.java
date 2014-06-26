// This is a generated file. Not intended for manual editing.
package com.technophobia.substeps.psi.substepsdefinition;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.technophobia.substeps.psi.substepsdefinition.SubstepsDefinitionTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import generated.psi.*;
import com.technophobia.substeps.psi.substepsdefinition.impl.SubstepsDefinitionPsiImplUtil;
import com.intellij.psi.PsiReference;

public class SubstepsDefinitionStepLineImpl extends ASTWrapperPsiElement implements SubstepsDefinitionStepLine {

  public SubstepsDefinitionStepLineImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SubstepsDefinitionVisitor) ((SubstepsDefinitionVisitor)visitor).visitStepLine(this);
    else super.accept(visitor);
  }

  public String definitionForStepText() {
    return SubstepsDefinitionPsiImplUtil.definitionForStepText(this);
  }

  public PsiReference[] getReferences() {
    return SubstepsDefinitionPsiImplUtil.getReferences(this);
  }

}
