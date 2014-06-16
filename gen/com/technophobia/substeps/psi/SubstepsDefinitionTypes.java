// This is a generated file. Not intended for manual editing.
package com.technophobia.substeps.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;

public interface SubstepsDefinitionTypes {


  IElementType COMMENT = new SubstepsDefinitionTokenType("COMMENT");
  IElementType CRLF = new SubstepsDefinitionTokenType("CRLF");
  IElementType DEFINITION = new SubstepsDefinitionTokenType("definition");
  IElementType STEP = new SubstepsDefinitionTokenType("step");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
