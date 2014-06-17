package com.technophobia.substeps.lexer.feature;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.technophobia.substeps.psi.feature.FeatureTypes;

%%

%class FeatureLexer
%implements FlexLexer
%unicode
%public

%function advance
%type IElementType
%eof{
    return;
%eof}

Crlf=\r|\n|\r\n
FirstTextCharacter=[^ \n\r\f\\] | "\\"{Crlf} | "\\".
TextCharacter=[^\n\r\f\\] | "\\"{Crlf} | "\\".
WhiteSpace=[\ \t\f]

FeatureLabel=Feature:
TagsLabel=Tags:
ScenarioLabel=Scenario:
ScenarioOutlinePrefix=Scenario
ScenarioOutlineSuffix=Outline:

Comment=("#"|"!")[^\r\n]*

%state CREATING_FEATURE_TEXT
%state CREATING_TAGS_TEXT
%state CREATING_SCENARIO_TEXT
%state CREATING_SCENARIO_OUTLINE_TEXT

%%

<YYINITIAL> {Comment}                                               { yybegin(YYINITIAL); return FeatureTypes.COMMENT; }

<YYINITIAL> {TagsLabel}                                             { yybegin(CREATING_TAGS_TEXT); return FeatureTypes.TAGS_LABEL; }

<YYINITIAL> {FeatureLabel}                                          { yybegin(CREATING_FEATURE_TEXT); return FeatureTypes.FEATURE_LABEL; }

<YYINITIAL> {ScenarioLabel}                                         { yybegin(CREATING_SCENARIO_TEXT); return FeatureTypes.SCENARIO_LABEL; }

<YYINITIAL> {ScenarioOutlinePrefix}{WhiteSpace}{ScenarioOutlineSuffix}                                  { yybegin(CREATING_SCENARIO_OUTLINE_TEXT); return FeatureTypes.SCENARIO_OUTLINE_LABEL; }

<YYINITIAL> {WhiteSpace}+{FirstTextCharacter}{TextCharacter}*       { yybegin(YYINITIAL); return FeatureTypes.STEP; }

<CREATING_FEATURE_TEXT> {Crlf}                                      { yybegin(YYINITIAL); return FeatureTypes.CRLF; }

<CREATING_FEATURE_TEXT> {WhiteSpace}+                               { yybegin(CREATING_FEATURE_TEXT); return TokenType.WHITE_SPACE; }

<CREATING_FEATURE_TEXT> {FirstTextCharacter}{TextCharacter}*        { yybegin(YYINITIAL); return FeatureTypes.FEATURE_TEXT; }

<CREATING_TAGS_TEXT> {Crlf}                                         { yybegin(YYINITIAL); return FeatureTypes.CRLF; }

<CREATING_TAGS_TEXT> {WhiteSpace}+                                  { yybegin(CREATING_TAGS_TEXT); return TokenType.WHITE_SPACE; }

<CREATING_TAGS_TEXT> {FirstTextCharacter}{TextCharacter}*           { yybegin(YYINITIAL); return FeatureTypes.TAGS_TEXT; }

<CREATING_SCENARIO_TEXT> {Crlf}                                     { yybegin(YYINITIAL); return FeatureTypes.CRLF; }

<CREATING_SCENARIO_TEXT> {WhiteSpace}+                              { yybegin(CREATING_SCENARIO_TEXT); return TokenType.WHITE_SPACE; }

<CREATING_SCENARIO_TEXT> {FirstTextCharacter}{TextCharacter}*       { yybegin(YYINITIAL); return FeatureTypes.SCENARIO_TEXT; }

<CREATING_SCENARIO_OUTLINE_TEXT> {Crlf}                             { yybegin(YYINITIAL); return FeatureTypes.CRLF; }

<CREATING_SCENARIO_OUTLINE_TEXT> {WhiteSpace}+                      { yybegin(CREATING_SCENARIO_OUTLINE_TEXT); return TokenType.WHITE_SPACE; }

<CREATING_SCENARIO_OUTLINE_TEXT> {FirstTextCharacter}{TextCharacter}* { yybegin(YYINITIAL); return FeatureTypes.SCENARIO_OUTLINE_TEXT; }

{Crlf}                                                              { yybegin(YYINITIAL); return FeatureTypes.CRLF; }

{WhiteSpace}+                                                       { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                                   { return TokenType.BAD_CHARACTER; }