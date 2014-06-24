package com.technophobia.substeps.lexer.substepsdefinition;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.technophobia.substeps.psi.substepsdefinition.SubstepsDefinitionTypes;

%%

%class SubstepsDefinitionLexer
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

DefineLabel="Define:"

//OtherDirective= (?!"Define:"][^\ \t\f]

Comment=("#"|"!")[^\r\n]*

%state CREATING_DEFINITION_TEXT

%state CREATING_DEFINITION_STEPS

%%

<YYINITIAL> {Comment}                                               { yybegin(YYINITIAL); return SubstepsDefinitionTypes.COMMENT; }

<YYINITIAL> {DefineLabel}                                           { yybegin(CREATING_DEFINITION_TEXT); return SubstepsDefinitionTypes.DEFINITION_LABEL; }

<CREATING_DEFINITION_TEXT> {Crlf}                                   { yybegin(CREATING_DEFINITION_STEPS); return SubstepsDefinitionTypes.CRLF; }

<CREATING_DEFINITION_TEXT> {FirstTextCharacter}{TextCharacter}*     { yybegin(CREATING_DEFINITION_TEXT); return SubstepsDefinitionTypes.DEFINITION_TEXT; }

<CREATING_DEFINITION_STEPS> {WhiteSpace}+{FirstTextCharacter}{TextCharacter}* { yybegin(CREATING_DEFINITION_STEPS); return SubstepsDefinitionTypes.STEP; }

<CREATING_DEFINITION_STEPS> {Crlf}                                  { yybegin(CREATING_DEFINITION_STEPS); return SubstepsDefinitionTypes.CRLF; }

<CREATING_DEFINITION_STEPS> {DefineLabel}                           { yybegin(CREATING_DEFINITION_TEXT); return SubstepsDefinitionTypes.DEFINITION_LABEL; }

<CREATING_DEFINITION_STEPS> {Comment}                               { yybegin(CREATING_DEFINITION_STEPS); return SubstepsDefinitionTypes.COMMENT; }

{Crlf}                                                              { yybegin(YYINITIAL); return SubstepsDefinitionTypes.CRLF; }

{WhiteSpace}+                                                       { return TokenType.WHITE_SPACE; }

.                                                                   { return TokenType.BAD_CHARACTER; }