package com.technophobia.substeps.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.technophobia.substeps.psi.SubstepsDefinitionTypes;

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
InputCharacter=[^\r\n]
WhiteSpace=[\ \t\f]

Comment=("#"|"!")[^\r\n]*

Text={InputCharacter}*

%state WAITING_VALUE

%%

<YYINITIAL> {Comment}                       { yybegin(YYINITIAL); return SubstepsDefinitionTypes.COMMENT; }

<YYINITIAL> Define:{Text}                   { yybegin(YYINITIAL); return SubstepsDefinitionTypes.DEFINITION; }

<YYINITIAL> {Text}                          { yybegin(YYINITIAL); return SubstepsDefinitionTypes.STEP; }

<WAITING_VALUE> {Crlf}                      { yybegin(YYINITIAL); return SubstepsDefinitionTypes.CRLF; }

<WAITING_VALUE> {WhiteSpace}+               { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

{Crlf}                                      { yybegin(YYINITIAL); return SubstepsDefinitionTypes.CRLF; }

{WhiteSpace}+                               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

. { return TokenType.BAD_CHARACTER; }