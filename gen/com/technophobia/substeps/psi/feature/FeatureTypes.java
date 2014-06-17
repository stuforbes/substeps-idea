// This is a generated file. Not intended for manual editing.
package com.technophobia.substeps.psi.feature;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;

public interface FeatureTypes {

  IElementType FEATURE = new FeatureElementType("FEATURE");
  IElementType SCENARIO = new FeatureElementType("SCENARIO");
  IElementType SCENARIO_OUTLINE = new FeatureElementType("SCENARIO_OUTLINE");
  IElementType TAGS = new FeatureElementType("TAGS");

  IElementType COMMENT = new FeatureTokenType("COMMENT");
  IElementType CRLF = new FeatureTokenType("CRLF");
  IElementType FEATURE_LABEL = new FeatureTokenType("FEATURE_LABEL");
  IElementType FEATURE_TEXT = new FeatureTokenType("FEATURE_TEXT");
  IElementType SCENARIO_LABEL = new FeatureTokenType("SCENARIO_LABEL");
  IElementType SCENARIO_OUTLINE_LABEL = new FeatureTokenType("SCENARIO_OUTLINE_LABEL");
  IElementType SCENARIO_OUTLINE_TEXT = new FeatureTokenType("SCENARIO_OUTLINE_TEXT");
  IElementType SCENARIO_TEXT = new FeatureTokenType("SCENARIO_TEXT");
  IElementType STEP = new FeatureTokenType("STEP");
  IElementType TAGS_LABEL = new FeatureTokenType("TAGS_LABEL");
  IElementType TAGS_TEXT = new FeatureTokenType("TAGS_TEXT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == FEATURE) {
        return new FeatureFeatureImpl(node);
      }
      else if (type == SCENARIO) {
        return new FeatureScenarioImpl(node);
      }
      else if (type == SCENARIO_OUTLINE) {
        return new FeatureScenarioOutlineImpl(node);
      }
      else if (type == TAGS) {
        return new FeatureTagsImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
