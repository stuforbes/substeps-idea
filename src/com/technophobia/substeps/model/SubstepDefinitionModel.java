package com.technophobia.substeps.model;

import com.intellij.psi.PsiElement;
import generated.psi.SubstepsDefinitionDefinition;

public class SubstepDefinitionModel implements PatternIdentifiedPsiElement {

    private final String filename;
    private final SubstepsDefinitionDefinition definition;

    public SubstepDefinitionModel(final SubstepsDefinitionDefinition definition, final String filename) {
        this.definition = definition;
        this.filename = filename;
    }

    public String getText() {
        return definition.definitionText();
    }

    public String getFilename() {
        return filename;
    }

    public int getOffset() {
        return definition.getStartOffsetInParent();
    }

    @Override
    public String pattern() {
        return getText();
    }

    @Override
    public PsiElement target() {
        return definition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubstepDefinitionModel that = (SubstepDefinitionModel) o;

        if (definition != null ? !definition.equals(that.definition) : that.definition != null) return false;
        if (filename != null ? !filename.equals(that.filename) : that.filename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filename != null ? filename.hashCode() : 0;
        result = 31 * result + (definition != null ? definition.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SubstepDefinitionModel{" +
                "text='" + getText() + '\'' +
                ", filename='" + filename + '\'' +
                ", offset=" + getOffset() +
                '}';
    }
}
