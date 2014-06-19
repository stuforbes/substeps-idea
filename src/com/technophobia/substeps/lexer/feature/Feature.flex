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
BackgroundLabel=Background:
TagsLabel=Tags:
ScenarioLabel=Scenario:
ScenarioOutlinePrefix=Scenario
ScenarioOutlineSuffix=Outline:
ExamplesLabel=Examples:

Comment=("#"|"!")[^\r\n]*

%state CREATING_FEATURE_TEXT
%state CREATING_BACKGROUND_TEXT
%state CREATING_BACKGROUND_STEPS
%state CREATING_TAGS_TEXT
%state CREATING_SCENARIO_TEXT
%state CREATING_SCENARIO_STEPS
%state CREATING_SCENARIO_OUTLINE_TEXT
%state CREATING_SCENARIO_OUTLINE_STEPS
%state CREATING_EXAMPLES
%state CREATING_EXAMPLES_TITLES
%state CREATING_EXAMPLES_VALUES

%%

<YYINITIAL> {Comment}                                                                       { yybegin(YYINITIAL); return FeatureTypes.COMMENT; }

<YYINITIAL> {FeatureLabel}                                                                  { yybegin(CREATING_FEATURE_TEXT); return FeatureTypes.FEATURE_LABEL; }

<YYINITIAL> {BackgroundLabel}                                                               { yybegin(CREATING_BACKGROUND_TEXT); return FeatureTypes.BACKGROUND_LABEL; }

<YYINITIAL> {TagsLabel}                                                                     { yybegin(CREATING_TAGS_TEXT); return FeatureTypes.TAGS_LABEL; }

<YYINITIAL> {ScenarioLabel}                                                                 { yybegin(CREATING_SCENARIO_TEXT); return FeatureTypes.SCENARIO_LABEL; }

<YYINITIAL> {ScenarioOutlinePrefix}{WhiteSpace}{ScenarioOutlineSuffix}                      { yybegin(CREATING_SCENARIO_OUTLINE_TEXT); return FeatureTypes.SCENARIO_OUTLINE_LABEL; }

<YYINITIAL> {ExamplesLabel}                                                                 { yybegin(CREATING_EXAMPLES); return FeatureTypes.EXAMPLE; }

<CREATING_FEATURE_TEXT> {WhiteSpace}+                                                       { yybegin(CREATING_FEATURE_TEXT); return TokenType.WHITE_SPACE; }

<CREATING_FEATURE_TEXT> {FirstTextCharacter}{TextCharacter}*                                { yybegin(CREATING_FEATURE_TEXT); return FeatureTypes.FEATURE_TEXT; }

<CREATING_FEATURE_TEXT> {Crlf}                                                              { yybegin(CREATING_FEATURE_TEXT); return FeatureTypes.CRLF; }

<CREATING_FEATURE_TEXT> {Crlf}{Crlf}                                                        { yybegin(YYINITIAL); return FeatureTypes.CRLF; }

<CREATING_FEATURE_TEXT> {Comment}                                                           { yybegin(CREATING_FEATURE_TEXT); return FeatureTypes.COMMENT; }

<CREATING_BACKGROUND_TEXT> {Crlf}                                                           { yybegin(CREATING_BACKGROUND_STEPS); return FeatureTypes.CRLF; }

<CREATING_BACKGROUND_TEXT> {Crlf}{Crlf}                                                     { yybegin(YYINITIAL); return FeatureTypes.CRLF; }

<CREATING_BACKGROUND_TEXT> {WhiteSpace}+                                                    { yybegin(CREATING_BACKGROUND_TEXT); return TokenType.WHITE_SPACE; }

<CREATING_BACKGROUND_TEXT> {FirstTextCharacter}{TextCharacter}*                             { yybegin(CREATING_BACKGROUND_STEPS); return FeatureTypes.BACKGROUND_TEXT; }

<CREATING_BACKGROUND_STEPS> {WhiteSpace}+{FirstTextCharacter}{TextCharacter}*               { yybegin(CREATING_BACKGROUND_STEPS); return FeatureTypes.BACKGROUND_STEP; }

<CREATING_BACKGROUND_STEPS> {Crlf}                                                          { yybegin(CREATING_BACKGROUND_STEPS); return FeatureTypes.CRLF; }

<CREATING_BACKGROUND_STEPS> {Crlf}{Crlf}                                                    { yybegin(YYINITIAL); return FeatureTypes.CRLF; }

<CREATING_BACKGROUND_STEPS> {Comment}                                                       { yybegin(CREATING_BACKGROUND_STEPS); return FeatureTypes.COMMENT; }

<CREATING_BACKGROUND_STEPS> {WhiteSpace}+                                                   { yybegin(CREATING_BACKGROUND_STEPS); return TokenType.WHITE_SPACE; }

<CREATING_TAGS_TEXT> {Crlf}                                                                 { yybegin(YYINITIAL); return FeatureTypes.CRLF; }

<CREATING_TAGS_TEXT> {WhiteSpace}+                                                          { yybegin(CREATING_TAGS_TEXT); return TokenType.WHITE_SPACE; }

<CREATING_TAGS_TEXT> {FirstTextCharacter}{TextCharacter}*                                   { yybegin(YYINITIAL); return FeatureTypes.TAGS_TEXT; }

<CREATING_SCENARIO_TEXT> {Crlf}                                                             { yybegin(CREATING_SCENARIO_STEPS); return FeatureTypes.CRLF; }

<CREATING_SCENARIO_TEXT> {Crlf}{Crlf}                                                       { yybegin(YYINITIAL); return FeatureTypes.CRLF; }

<CREATING_SCENARIO_TEXT> {WhiteSpace}+                                                      { yybegin(CREATING_SCENARIO_TEXT); return TokenType.WHITE_SPACE; }

<CREATING_SCENARIO_TEXT> {FirstTextCharacter}{TextCharacter}*                               { yybegin(CREATING_SCENARIO_STEPS); return FeatureTypes.SCENARIO_TEXT; }

<CREATING_SCENARIO_STEPS> {WhiteSpace}+{FirstTextCharacter}{TextCharacter}*                 { yybegin(CREATING_SCENARIO_STEPS); return FeatureTypes.SCENARIO_STEP; }

<CREATING_SCENARIO_STEPS> {Crlf}                                                            { yybegin(CREATING_SCENARIO_STEPS); return FeatureTypes.CRLF; }

<CREATING_SCENARIO_STEPS> {Crlf}{Crlf}                                                      { yybegin(YYINITIAL); return FeatureTypes.CRLF; }

<CREATING_SCENARIO_STEPS> {Comment}                                                         { yybegin(CREATING_SCENARIO_STEPS); return FeatureTypes.COMMENT; }

<CREATING_SCENARIO_STEPS> {WhiteSpace}+                                                     { yybegin(CREATING_SCENARIO_STEPS); return TokenType.WHITE_SPACE; }

<CREATING_SCENARIO_OUTLINE_TEXT> {Crlf}                                                     { yybegin(CREATING_SCENARIO_OUTLINE_STEPS); return FeatureTypes.CRLF; }

<CREATING_SCENARIO_OUTLINE_TEXT> {Crlf}{Crlf}                                               { yybegin(YYINITIAL); return FeatureTypes.CRLF; }

<CREATING_SCENARIO_OUTLINE_TEXT> {WhiteSpace}+                                              { yybegin(CREATING_SCENARIO_OUTLINE_TEXT); return TokenType.WHITE_SPACE; }

<CREATING_SCENARIO_OUTLINE_TEXT> {FirstTextCharacter}{TextCharacter}*                       { yybegin(CREATING_SCENARIO_OUTLINE_STEPS); return FeatureTypes.SCENARIO_OUTLINE_TEXT; }

<CREATING_SCENARIO_OUTLINE_STEPS> {WhiteSpace}+{FirstTextCharacter}{TextCharacter}*         { yybegin(CREATING_SCENARIO_OUTLINE_STEPS); return FeatureTypes.SCENARIO_OUTLINE_STEP; }

<CREATING_SCENARIO_OUTLINE_STEPS> {Crlf}                                                    { yybegin(CREATING_SCENARIO_OUTLINE_STEPS); return FeatureTypes.CRLF; }

<CREATING_SCENARIO_OUTLINE_STEPS> {Crlf}{Crlf}                                              { yybegin(YYINITIAL); return FeatureTypes.CRLF; }

<CREATING_SCENARIO_OUTLINE_STEPS> {Comment}                                                 { yybegin(CREATING_SCENARIO_OUTLINE_STEPS); return FeatureTypes.COMMENT; }

<CREATING_SCENARIO_OUTLINE_STEPS> {WhiteSpace}+                                             { yybegin(CREATING_SCENARIO_OUTLINE_STEPS); return TokenType.WHITE_SPACE; }

<CREATING_EXAMPLES> {Crlf}                                                                  { yybegin(CREATING_EXAMPLES_TITLES); return FeatureTypes.CRLF; }

<CREATING_EXAMPLES_TITLES> {Crlf}                                                           { yybegin(CREATING_EXAMPLES_VALUES); return FeatureTypes.CRLF; }

<CREATING_EXAMPLES_TITLES> {WhiteSpace}*                                                     { yybegin(CREATING_EXAMPLES_TITLES); return TokenType.WHITE_SPACE; }

//<CREATING_EXAMPLES_TITLES> "|"                                                              { yybegin(CREATING_EXAMPLES_TITLES); return FeatureTypes.EXAMPLE_TITLE_SEPARATOR; }

<CREATING_EXAMPLES_TITLES> {FirstTextCharacter}{TextCharacter}*                             { yybegin(CREATING_EXAMPLES_TITLES); return FeatureTypes.EXAMPLE_TITLE_ROW; }

<CREATING_EXAMPLES_VALUES> {Crlf}                                                           { yybegin(CREATING_EXAMPLES_VALUES); return FeatureTypes.CRLF; }

<CREATING_EXAMPLES_VALUES> {Crlf}{Crlf}                                                     { yybegin(YYINITIAL); return FeatureTypes.CRLF; }

<CREATING_EXAMPLES_VALUES> {Comment}                                                        { yybegin(CREATING_EXAMPLES_VALUES); return FeatureTypes.COMMENT; }

<CREATING_EXAMPLES_VALUES> {WhiteSpace}*                                                     { yybegin(CREATING_EXAMPLES_VALUES); return TokenType.WHITE_SPACE; }

<CREATING_EXAMPLES_VALUES> {FirstTextCharacter}{TextCharacter}*                             { yybegin(CREATING_EXAMPLES_VALUES); return FeatureTypes.EXAMPLE_VALUE_ROW; }

{Crlf}                                                                                      { yybegin(YYINITIAL); return FeatureTypes.CRLF; }

//{WhiteSpace}+                                                                               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                                                           { return TokenType.BAD_CHARACTER; }