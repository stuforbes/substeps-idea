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

public class SubstepsDefinitionDefinitionImpl extends ASTWrapperPsiElement implements SubstepsDefinitionDefinition {

  public SubstepsDefinitionDefinitionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SubstepsDefinitionVisitor) ((SubstepsDefinitionVisitor)visitor).visitDefinition(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SubstepsDefinitionDefinitionTextBlock getDefinitionTextBlock() {
    return findChildByClass(SubstepsDefinitionDefinitionTextBlock.class);
  }

}
