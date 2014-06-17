// This is a generated file. Not intended for manual editing.
package com.technophobia.substeps.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.technophobia.substeps.psi.SubstepsDefinitionTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import generated.psi.*;

public class SubstepsDefinitionDefinitionImpl extends ASTWrapperPsiElement implements SubstepsDefinitionDefinition {

  public SubstepsDefinitionDefinitionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SubstepsDefinitionVisitor) ((SubstepsDefinitionVisitor)visitor).visitDefinition(this);
    else super.accept(visitor);
  }

}
