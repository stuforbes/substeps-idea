package com.technophobia.substeps.syntax;

import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.ui.JBColor;

import java.awt.*;

public enum Colours {

    DIRECTIVE_LABEL(new TextAttributes(JBColor.BLUE, null, null, null, Font.BOLD)),
    TAGS_LABEL(new TextAttributes(JBColor.GREEN.darker(), null, null, null, Font.BOLD)),
    EXAMPLES_LABELS(new TextAttributes(JBColor.BLACK, null, null, null, Font.BOLD)),
    ERROR_CHAR(new TextAttributes(JBColor.RED, null, null, null, Font.BOLD));

    private final TextAttributes textAttributes;

    private Colours(final TextAttributes textAttributes){
        this.textAttributes = textAttributes;
    }

    public TextAttributes attributes(){
        return textAttributes;
    }
}
