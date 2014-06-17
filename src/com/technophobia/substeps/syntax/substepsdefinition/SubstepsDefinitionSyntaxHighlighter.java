package com.technophobia.substeps.syntax.substepsdefinition;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.SyntaxHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.ui.JBColor;
import com.technophobia.substeps.lexer.substepsdefinition.SubstepsDefinitionLexer;
import com.technophobia.substeps.psi.substepsdefinition.SubstepsDefinitionTypes;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.Reader;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class SubstepsDefinitionSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey DEFINITION_LABEL = substepDefinitionTextAttributeKey("LABEL", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey DEFINITION_TEXT = substepDefinitionTextAttributeKey("TEXT", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
    public static final TextAttributesKey COMMENT = substepDefinitionTextAttributeKey("COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);

    static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("SUBSTEPS_DEFINITION_BAD_CHARACTER", new TextAttributes(JBColor.RED, null, null, null, Font.BOLD));

    private static final TextAttributesKey[] BAD_CHAR_KEYS = asArray(BAD_CHARACTER);
    private static final TextAttributesKey[] DEFINITION_LABEL_KEYS = asArray(DEFINITION_LABEL);
    private static final TextAttributesKey[] DEFINITION_TEXT_KEYS = asArray(DEFINITION_TEXT);
    private static final TextAttributesKey[] COMMENT_KEYS = asArray(COMMENT);
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new FlexAdapter(new SubstepsDefinitionLexer((Reader)null));
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if(tokenType.equals(SubstepsDefinitionTypes.DEFINITION_LABEL)){
            return DEFINITION_LABEL_KEYS;
        } else if(tokenType.equals(SubstepsDefinitionTypes.DEFINITION_TEXT)){
            return DEFINITION_TEXT_KEYS;
        } else if(tokenType.equals(SubstepsDefinitionTypes.COMMENT)){
            return COMMENT_KEYS;
        } else if(tokenType.equals(TokenType.BAD_CHARACTER)){
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }

    private static TextAttributesKey substepDefinitionTextAttributeKey(final String localName, final TextAttributesKey fallback) {
        return createTextAttributesKey("SUBSTEPS_DEFINITION_"+localName, fallback);
    }

    private static TextAttributesKey[] asArray(final TextAttributesKey key){
        return new TextAttributesKey[]{key};
    }
}
