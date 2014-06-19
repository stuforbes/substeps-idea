// This is a generated file. Not intended for manual editing.
package com.technophobia.substeps.parser.substepsdefinition;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.openapi.diagnostic.Logger;
import static com.technophobia.substeps.psi.substepsdefinition.SubstepsDefinitionTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SubstepsParser implements PsiParser {

  public static final Logger LOG_ = Logger.getInstance("com.technophobia.substeps.parser.substepsdefinition.SubstepsParser");

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    if (root_ == DEFINITION) {
      result_ = definition(builder_, 0);
    }
    else {
      result_ = parse_root_(root_, builder_, 0);
    }
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
    return builder_.getTreeBuilt();
  }

  protected boolean parse_root_(final IElementType root_, final PsiBuilder builder_, final int level_) {
    return substepsFile(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // (DEFINITION_LABEL DEFINITION_TEXT?) | KEY
  public static boolean definition(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "definition")) return false;
    if (!nextTokenIs(builder_, "<definition>", DEFINITION_LABEL, KEY)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<definition>");
    result_ = definition_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, KEY);
    exit_section_(builder_, level_, marker_, DEFINITION, result_, false, null);
    return result_;
  }

  // DEFINITION_LABEL DEFINITION_TEXT?
  private static boolean definition_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "definition_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, DEFINITION_LABEL);
    result_ = result_ && definition_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // DEFINITION_TEXT?
  private static boolean definition_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "definition_0_1")) return false;
    consumeToken(builder_, DEFINITION_TEXT);
    return true;
  }

  /* ********************************************************** */
  // definition|STEP|COMMENT|CRLF
  static boolean item_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "item_")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = definition(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, STEP);
    if (!result_) result_ = consumeToken(builder_, COMMENT);
    if (!result_) result_ = consumeToken(builder_, CRLF);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // item_*
  static boolean substepsFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "substepsFile")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!item_(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "substepsFile", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

}
