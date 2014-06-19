package com.technophobia.substeps.settings.substepsdefinition;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.technophobia.substeps.language.SubstepsIcons;
import com.technophobia.substeps.syntax.substepsdefinition.SubstepsDefinitionSyntaxHighlighter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class SubstepsDefinitionColourSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Definition label", SubstepsDefinitionSyntaxHighlighter.DEFINITION_LABEL),
            new AttributesDescriptor("Definition text", SubstepsDefinitionSyntaxHighlighter.DEFINITION_TEXT),
            new AttributesDescriptor("Steps", SubstepsDefinitionSyntaxHighlighter.STEP),
            new AttributesDescriptor("Comment", SubstepsDefinitionSyntaxHighlighter.COMMENT)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return SubstepsIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new SubstepsDefinitionSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "#This is a comment\n" +
               "Define: This is a substep definition\n" +
               "\tGiven a pre-condition\n" +
               "\tWhen I do something\n" +
               "\tThen a condition will be true";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Substeps";
    }
}
