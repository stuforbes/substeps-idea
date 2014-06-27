// This is a generated file. Not intended for manual editing.
package generated.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ContributedReferenceHost;
import com.technophobia.substeps.psi.feature.ScenarioElement;

public class FeatureVisitor extends PsiElementVisitor {

  public void visitBackground(@NotNull FeatureBackground o) {
    visitPsiElement(o);
  }

  public void visitBackgroundStepLine(@NotNull FeatureBackgroundStepLine o) {
    visitContributedReferenceHost(o);
  }

  public void visitFeature(@NotNull FeatureFeature o) {
    visitPsiElement(o);
  }

  public void visitScenario(@NotNull FeatureScenario o) {
    visitScenarioElement(o);
  }

  public void visitScenarioOutlineStepLine(@NotNull FeatureScenarioOutlineStepLine o) {
    visitContributedReferenceHost(o);
  }

  public void visitScenarioStepLine(@NotNull FeatureScenarioStepLine o) {
    visitContributedReferenceHost(o);
  }

  public void visitScenarioOutline(@NotNull FeatureScenarioOutline o) {
    visitScenarioElement(o);
  }

  public void visitTags(@NotNull FeatureTags o) {
    visitPsiElement(o);
  }

  public void visitContributedReferenceHost(@NotNull ContributedReferenceHost o) {
    visitElement(o);
  }

  public void visitScenarioElement(@NotNull ScenarioElement o) {
    visitElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
