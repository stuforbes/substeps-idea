// This is a generated file. Not intended for manual editing.
package generated.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import com.technophobia.substeps.psi.substepsdefinition.SubstepDefinitionNamedElement;
import com.intellij.psi.ContributedReferenceHost;

public class SubstepsDefinitionVisitor extends PsiElementVisitor {

  public void visitDefinition(@NotNull SubstepsDefinitionDefinition o) {
    visitPsiElement(o);
  }

  public void visitDefinitionTextBlock(@NotNull SubstepsDefinitionDefinitionTextBlock o) {
    visitSubstepDefinitionNamedElement(o);
  }

  public void visitStepLine(@NotNull SubstepsDefinitionStepLine o) {
    visitContributedReferenceHost(o);
  }

  public void visitContributedReferenceHost(@NotNull ContributedReferenceHost o) {
    visitElement(o);
  }

  public void visitSubstepDefinitionNamedElement(@NotNull SubstepDefinitionNamedElement o) {
    visitElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
