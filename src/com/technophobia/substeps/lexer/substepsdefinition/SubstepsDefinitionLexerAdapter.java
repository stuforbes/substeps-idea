package com.technophobia.substeps.lexer.substepsdefinition;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class SubstepsDefinitionLexerAdapter extends FlexAdapter {
    public SubstepsDefinitionLexerAdapter() {
        super(new SubstepsDefinitionLexer((Reader)null));
    }
}
