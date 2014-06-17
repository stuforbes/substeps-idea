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

DefineLabel=Define:

Comment=("#"|"!")[^\r\n]*

%state CREATING_DEFINITION_TEXT

%%

<YYINITIAL> {Comment}                                               { yybegin(YYINITIAL); return SubstepsDefinitionTypes.COMMENT; }

<YYINITIAL> {DefineLabel}                                           { yybegin(CREATING_DEFINITION_TEXT); return SubstepsDefinitionTypes.DEFINITION_LABEL; }

<CREATING_DEFINITION_TEXT> {Crlf}                                   { yybegin(YYINITIAL); return SubstepsDefinitionTypes.CRLF; }

<CREATING_DEFINITION_TEXT> {WhiteSpace}+                            { yybegin(CREATING_DEFINITION_TEXT); return TokenType.WHITE_SPACE; }

<CREATING_DEFINITION_TEXT> {FirstTextCharacter}{TextCharacter}*     { yybegin(YYINITIAL); return SubstepsDefinitionTypes.DEFINITION_TEXT; }

<YYINITIAL> {WhiteSpace}+{FirstTextCharacter}{TextCharacter}*       { yybegin(YYINITIAL); return SubstepsDefinitionTypes.STEP; }

{Crlf}                                                              { yybegin(YYINITIAL); return SubstepsDefinitionTypes.CRLF; }

{WhiteSpace}+                                                       { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                                   { return TokenType.BAD_CHARACTER; }