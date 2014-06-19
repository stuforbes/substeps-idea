package com.technophobia.substeps.syntax.feature;

import com.google.common.collect.Maps;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.ui.JBColor;
import com.technophobia.substeps.lexer.feature.FeatureLexer;
import com.technophobia.substeps.lexer.substepsdefinition.SubstepsDefinitionLexer;
import com.technophobia.substeps.psi.feature.FeatureTypes;
import com.technophobia.substeps.syntax.Colours;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.Reader;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class FeatureSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey FEATURE_LABEL = featureTextAttributeKey("FEATURE_LABEL", Colours.DIRECTIVE_LABEL.attributes());
    public static final TextAttributesKey FEATURE_TEXT = featureTextAttributeKey("FEATURE_TEXT", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);

    public static final TextAttributesKey BACKGROUND_LABEL = featureTextAttributeKey("BACKGROUND_LABEL", Colours.DIRECTIVE_LABEL.attributes());
    public static final TextAttributesKey BACKGROUND_TEXT = featureTextAttributeKey("BACKGROUND_TEXT", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);

    public static final TextAttributesKey TAGS_LABEL = featureTextAttributeKey("TAGS_LABEL", Colours.TAGS_LABEL.attributes());
    public static final TextAttributesKey TAGS_TEXT = featureTextAttributeKey("TAGS_TEXT", Colours.TAGS_LABEL.attributes());

    public static final TextAttributesKey SCENARIO_LABEL = featureTextAttributeKey("SCENARIO_LABEL", Colours.DIRECTIVE_LABEL.attributes());
    public static final TextAttributesKey SCENARIO_TEXT = featureTextAttributeKey("SCENARIO_TEXT", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);

    public static final TextAttributesKey SCENARIO_OUTLINE_LABEL = featureTextAttributeKey("SCENARIO_OUTLINE_LABEL", Colours.DIRECTIVE_LABEL.attributes());
    public static final TextAttributesKey SCENARIO_OUTLINE_TEXT = featureTextAttributeKey("SCENARIO_OUTLINE_TEXT", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);

    public static final TextAttributesKey EXAMPLES_LABEL = featureTextAttributeKey("EXAMPLES_LABEL", Colours.DIRECTIVE_LABEL.attributes());
    public static final TextAttributesKey EXAMPLES_FIELD_NAME = featureTextAttributeKey("EXAMPLES_FIELD_NAME", Colours.EXAMPLES_LABELS.attributes());
    public static final TextAttributesKey EXAMPLES_FIELD_VALUE = featureTextAttributeKey("EXAMPLES_FIELD_VALUE", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);

    public static final TextAttributesKey EXAMPLES_ROW = featureTextAttributeKey("EXAMPLES_ROW", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);

    public static final TextAttributesKey STEP = featureTextAttributeKey("STEP", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
    public static final TextAttributesKey COMMENT = featureTextAttributeKey("COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);

    static final TextAttributesKey BAD_CHARACTER = featureTextAttributeKey("BAD_CHARACTER", Colours.ERROR_CHAR.attributes());

    private static final TextAttributesKey[] BAD_CHAR_KEYS = asArray(BAD_CHARACTER);
    private static final TextAttributesKey[] FEATURE_LABEL_KEYS = asArray(FEATURE_LABEL);
    private static final TextAttributesKey[] FEATURE_TEXT_KEYS = asArray(FEATURE_TEXT);
    private static final TextAttributesKey[] BACKGROUND_LABEL_KEYS = asArray(BACKGROUND_LABEL);
    private static final TextAttributesKey[] BACKGROUND_TEXT_KEYS = asArray(BACKGROUND_TEXT);
    private static final TextAttributesKey[] TAGS_LABEL_KEYS = asArray(TAGS_LABEL);
    private static final TextAttributesKey[] TAGS_TEXT_KEYS = asArray(TAGS_TEXT);
    private static final TextAttributesKey[] SCENARIO_LABEL_KEYS = asArray(SCENARIO_LABEL);
    private static final TextAttributesKey[] SCENARIO_TEXT_KEYS = asArray(SCENARIO_TEXT);
    private static final TextAttributesKey[] SCENARIO_OUTLINE_LABEL_KEYS = asArray(SCENARIO_OUTLINE_LABEL);
    private static final TextAttributesKey[] SCENARIO_OUTLINE_TEXT_KEYS = asArray(SCENARIO_OUTLINE_TEXT);
    private static final TextAttributesKey[] EXAMPLE_KEYS = asArray(EXAMPLES_LABEL);
    private static final TextAttributesKey[] EXAMPLE_FIELD_NAME_KEYS = asArray(EXAMPLES_FIELD_NAME);
    private static final TextAttributesKey[] EXAMPLE_FIELD_VALUE_KEYS = asArray(EXAMPLES_FIELD_VALUE);

    private static final TextAttributesKey[] STEP_KEYS = asArray(STEP);
    private static final TextAttributesKey[] COMMENT_KEYS = asArray(COMMENT);
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    private static final Map<IElementType, TextAttributesKey[]> typeToAttributeKeyMap = createTypeToAttributeKeyMap();



    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new FlexAdapter(new FeatureLexer((Reader)null));
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if(typeToAttributeKeyMap.containsKey(tokenType)){
            return typeToAttributeKeyMap.get(tokenType);
        }
        return EMPTY_KEYS;
    }

    private static TextAttributesKey featureTextAttributeKey(final String localName, final TextAttributesKey fallback) {
        return createTextAttributesKey("FEATURE_"+localName, fallback);
    }

    private static TextAttributesKey featureTextAttributeKey(final String localName, final TextAttributes fallback) {
        return createTextAttributesKey("FEATURE_"+localName, fallback);
    }

    private static TextAttributesKey[] asArray(final TextAttributesKey key){
        return new TextAttributesKey[]{key};
    }

    private static Map<IElementType, TextAttributesKey[]> createTypeToAttributeKeyMap() {
        Map<IElementType, TextAttributesKey[]> results = Maps.newHashMap();

        results.put(FeatureTypes.FEATURE_LABEL, FEATURE_LABEL_KEYS);
        results.put(FeatureTypes.FEATURE_TEXT, FEATURE_TEXT_KEYS);
        results.put(FeatureTypes.BACKGROUND_LABEL, BACKGROUND_LABEL_KEYS);
        results.put(FeatureTypes.BACKGROUND_TEXT, BACKGROUND_TEXT_KEYS);
        results.put(FeatureTypes.TAGS_LABEL, TAGS_LABEL_KEYS);
        results.put(FeatureTypes.TAGS_TEXT, TAGS_TEXT_KEYS);
        results.put(FeatureTypes.SCENARIO_LABEL, SCENARIO_LABEL_KEYS);
        results.put(FeatureTypes.SCENARIO_TEXT, SCENARIO_TEXT_KEYS);
        results.put(FeatureTypes.SCENARIO_OUTLINE_LABEL, SCENARIO_OUTLINE_LABEL_KEYS);
        results.put(FeatureTypes.SCENARIO_OUTLINE_TEXT, SCENARIO_OUTLINE_TEXT_KEYS);
        results.put(FeatureTypes.EXAMPLE, EXAMPLE_KEYS);
        results.put(FeatureTypes.EXAMPLE_TITLE_ROW, EXAMPLE_FIELD_NAME_KEYS);
        results.put(FeatureTypes.EXAMPLE_VALUE_ROW, EXAMPLE_FIELD_VALUE_KEYS);
//        results.put(FeatureTypes.EXAMPLE_FIELD_VALUE, EXAMPLE_FIELD_VALUE_KEYS);
        results.put(FeatureTypes.BACKGROUND_STEP, STEP_KEYS);
        results.put(FeatureTypes.SCENARIO_STEP, STEP_KEYS);
        results.put(FeatureTypes.SCENARIO_OUTLINE_STEP, STEP_KEYS);
        results.put(FeatureTypes.COMMENT, COMMENT_KEYS);

        return results;
    }
}
