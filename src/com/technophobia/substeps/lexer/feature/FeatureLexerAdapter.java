package com.technophobia.substeps.lexer.feature;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class FeatureLexerAdapter extends FlexAdapter {
    public FeatureLexerAdapter() {
        super(new FeatureLexer((Reader)null));
    }
}
