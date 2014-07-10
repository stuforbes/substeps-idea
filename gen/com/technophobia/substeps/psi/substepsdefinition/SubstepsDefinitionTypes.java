// This is a generated file. Not intended for manual editing.
package com.technophobia.substeps.psi.substepsdefinition;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;

public interface SubstepsDefinitionTypes {

  IElementType DEFINITION = new SubstepsDefinitionElementType("DEFINITION");
  IElementType DEFINITION_TEXT_BLOCK = new SubstepsDefinitionElementType("DEFINITION_TEXT_BLOCK");
  IElementType STEP_LINE = new SubstepsDefinitionElementType("STEP_LINE");

  IElementType COMMENT = new SubstepsDefinitionTokenType("COMMENT");
  IElementType CRLF = new SubstepsDefinitionTokenType("CRLF");
  IElementType DEFINITION_LABEL = new SubstepsDefinitionTokenType("DEFINITION_LABEL");
  IElementType DEFINITION_TEXT = new SubstepsDefinitionTokenType("DEFINITION_TEXT");
  IElementType GENERAL_DIRECTIVE = new SubstepsDefinitionTokenType("GENERAL_DIRECTIVE");
  IElementType STEP = new SubstepsDefinitionTokenType("STEP");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == DEFINITION) {
        return new SubstepsDefinitionDefinitionImpl(node);
      }
      else if (type == DEFINITION_TEXT_BLOCK) {
        return new SubstepsDefinitionDefinitionTextBlockImpl(node);
      }
      else if (type == STEP_LINE) {
        return new SubstepsDefinitionStepLineImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
