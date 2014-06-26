// This is a generated file. Not intended for manual editing.
package com.technophobia.substeps.psi.feature;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.technophobia.substeps.psi.feature.FeatureTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import generated.psi.*;
import com.technophobia.substeps.psi.substepsdefinition.impl.SubstepsDefinitionPsiImplUtil;

public class FeatureScenarioOutlineStepLineImpl extends ASTWrapperPsiElement implements FeatureScenarioOutlineStepLine {

  public FeatureScenarioOutlineStepLineImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FeatureVisitor) ((FeatureVisitor)visitor).visitScenarioOutlineStepLine(this);
    else super.accept(visitor);
  }

  public String definitionForStepText() {
    return SubstepsDefinitionPsiImplUtil.definitionForStepText(this);
  }

}
