// This is a generated file. Not intended for manual editing.
package com.technophobia.substeps.parser.feature;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.openapi.diagnostic.Logger;
import static com.technophobia.substeps.psi.feature.FeatureTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class FeatureParser implements PsiParser {

  public static final Logger LOG_ = Logger.getInstance("com.technophobia.substeps.parser.feature.FeatureParser");

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    if (root_ == BACKGROUND) {
      result_ = background(builder_, 0);
    }
    else if (root_ == BACKGROUND_STEP_LINE) {
      result_ = backgroundStepLine(builder_, 0);
    }
    else if (root_ == FEATURE) {
      result_ = feature(builder_, 0);
    }
    else if (root_ == SCENARIO) {
      result_ = scenario(builder_, 0);
    }
    else if (root_ == SCENARIO_OUTLINE_STEP_LINE) {
      result_ = scenarioOutlineStepLine(builder_, 0);
    }
    else if (root_ == SCENARIO_STEP_LINE) {
      result_ = scenarioStepLine(builder_, 0);
    }
    else if (root_ == SCENARIO_OUTLINE) {
      result_ = scenario_outline(builder_, 0);
    }
    else if (root_ == TAGS) {
      result_ = tags(builder_, 0);
    }
    else {
      result_ = parse_root_(root_, builder_, 0);
    }
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
    return builder_.getTreeBuilt();
  }

  protected boolean parse_root_(final IElementType root_, final PsiBuilder builder_, final int level_) {
    return featureFile(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // BACKGROUND_LABEL BACKGROUND_TEXT?
  public static boolean background(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "background")) return false;
    if (!nextTokenIs(builder_, BACKGROUND_LABEL)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, BACKGROUND_LABEL);
    result_ = result_ && background_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, BACKGROUND, result_);
    return result_;
  }

  // BACKGROUND_TEXT?
  private static boolean background_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "background_1")) return false;
    consumeToken(builder_, BACKGROUND_TEXT);
    return true;
  }

  /* ********************************************************** */
  // (BACKGROUND_STEP) | BACKGROUND_STEP
  public static boolean backgroundStepLine(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "backgroundStepLine")) return false;
    if (!nextTokenIs(builder_, BACKGROUND_STEP)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, BACKGROUND_STEP);
    if (!result_) result_ = consumeToken(builder_, BACKGROUND_STEP);
    exit_section_(builder_, marker_, BACKGROUND_STEP_LINE, result_);
    return result_;
  }

  /* ********************************************************** */
  // FEATURE_LABEL FEATURE_TEXT?
  public static boolean feature(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "feature")) return false;
    if (!nextTokenIs(builder_, FEATURE_LABEL)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, FEATURE_LABEL);
    result_ = result_ && feature_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, FEATURE, result_);
    return result_;
  }

  // FEATURE_TEXT?
  private static boolean feature_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "feature_1")) return false;
    consumeToken(builder_, FEATURE_TEXT);
    return true;
  }

  /* ********************************************************** */
  // item_*
  static boolean featureFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "featureFile")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!item_(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "featureFile", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // feature|FEATURE_TEXT|tags|background|backgroundStepLine|scenario|scenarioStepLine|scenario_outline|scenarioOutlineStepLine|EXAMPLE|COMMENT|CRLF|EXAMPLE_TITLE_ROW|EXAMPLE_VALUE_ROW
  static boolean item_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "item_")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = feature(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, FEATURE_TEXT);
    if (!result_) result_ = tags(builder_, level_ + 1);
    if (!result_) result_ = background(builder_, level_ + 1);
    if (!result_) result_ = backgroundStepLine(builder_, level_ + 1);
    if (!result_) result_ = scenario(builder_, level_ + 1);
    if (!result_) result_ = scenarioStepLine(builder_, level_ + 1);
    if (!result_) result_ = scenario_outline(builder_, level_ + 1);
    if (!result_) result_ = scenarioOutlineStepLine(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, EXAMPLE);
    if (!result_) result_ = consumeToken(builder_, COMMENT);
    if (!result_) result_ = consumeToken(builder_, CRLF);
    if (!result_) result_ = consumeToken(builder_, EXAMPLE_TITLE_ROW);
    if (!result_) result_ = consumeToken(builder_, EXAMPLE_VALUE_ROW);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // SCENARIO_LABEL SCENARIO_TEXT?
  public static boolean scenario(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "scenario")) return false;
    if (!nextTokenIs(builder_, SCENARIO_LABEL)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, SCENARIO_LABEL);
    result_ = result_ && scenario_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, SCENARIO, result_);
    return result_;
  }

  // SCENARIO_TEXT?
  private static boolean scenario_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "scenario_1")) return false;
    consumeToken(builder_, SCENARIO_TEXT);
    return true;
  }

  /* ********************************************************** */
  // (SCENARIO_OUTLINE_STEP) | SCENARIO_OUTLINE_STEP
  public static boolean scenarioOutlineStepLine(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "scenarioOutlineStepLine")) return false;
    if (!nextTokenIs(builder_, SCENARIO_OUTLINE_STEP)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, SCENARIO_OUTLINE_STEP);
    if (!result_) result_ = consumeToken(builder_, SCENARIO_OUTLINE_STEP);
    exit_section_(builder_, marker_, SCENARIO_OUTLINE_STEP_LINE, result_);
    return result_;
  }

  /* ********************************************************** */
  // (SCENARIO_STEP) | SCENARIO_STEP
  public static boolean scenarioStepLine(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "scenarioStepLine")) return false;
    if (!nextTokenIs(builder_, SCENARIO_STEP)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, SCENARIO_STEP);
    if (!result_) result_ = consumeToken(builder_, SCENARIO_STEP);
    exit_section_(builder_, marker_, SCENARIO_STEP_LINE, result_);
    return result_;
  }

  /* ********************************************************** */
  // SCENARIO_OUTLINE_LABEL SCENARIO_OUTLINE_TEXT?
  public static boolean scenario_outline(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "scenario_outline")) return false;
    if (!nextTokenIs(builder_, SCENARIO_OUTLINE_LABEL)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, SCENARIO_OUTLINE_LABEL);
    result_ = result_ && scenario_outline_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, SCENARIO_OUTLINE, result_);
    return result_;
  }

  // SCENARIO_OUTLINE_TEXT?
  private static boolean scenario_outline_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "scenario_outline_1")) return false;
    consumeToken(builder_, SCENARIO_OUTLINE_TEXT);
    return true;
  }

  /* ********************************************************** */
  // TAGS_LABEL TAGS_TEXT?
  public static boolean tags(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tags")) return false;
    if (!nextTokenIs(builder_, TAGS_LABEL)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, TAGS_LABEL);
    result_ = result_ && tags_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, TAGS, result_);
    return result_;
  }

  // TAGS_TEXT?
  private static boolean tags_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tags_1")) return false;
    consumeToken(builder_, TAGS_TEXT);
    return true;
  }

}
