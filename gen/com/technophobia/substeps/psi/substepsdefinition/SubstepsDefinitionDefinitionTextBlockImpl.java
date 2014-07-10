// This is a generated file. Not intended for manual editing.
package com.technophobia.substeps.psi.substepsdefinition;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.technophobia.substeps.psi.substepsdefinition.SubstepsDefinitionTypes.*;
import com.technophobia.substeps.psi.substepsdefinition.impl.SubstepDefinitionNamedElementImpl;
import generated.psi.*;
import com.technophobia.substeps.psi.substepsdefinition.impl.SubstepsDefinitionPsiImplUtil;

public class SubstepsDefinitionDefinitionTextBlockImpl extends SubstepDefinitionNamedElementImpl implements SubstepsDefinitionDefinitionTextBlock {

  public SubstepsDefinitionDefinitionTextBlockImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SubstepsDefinitionVisitor) ((SubstepsDefinitionVisitor)visitor).visitDefinitionTextBlock(this);
    else super.accept(visitor);
  }

  public String definitionText() {
    return SubstepsDefinitionPsiImplUtil.definitionText(this);
  }

  public PsiElement getNameIdentifier() {
    return SubstepsDefinitionPsiImplUtil.getNameIdentifier(this);
  }

  public String getName() {
    return SubstepsDefinitionPsiImplUtil.getName(this);
  }

  public PsiElement setName(String newName) {
    return SubstepsDefinitionPsiImplUtil.setName(this, newName);
  }

}
