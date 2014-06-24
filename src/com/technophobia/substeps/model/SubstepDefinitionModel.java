package com.technophobia.substeps.model;

public class SubstepDefinitionModel implements Patterned{

    private final String text;
    private final String filename;
    private final int offset;

    public SubstepDefinitionModel(String text, String filename, int offset) {
        this.text = text;
        this.filename = filename;
        this.offset = offset;
    }

    public String getText() {
        return text;
    }

    public String getFilename() {
        return filename;
    }

    public int getOffset() {
        return offset;
    }

    @Override
    public String pattern() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubstepDefinitionModel that = (SubstepDefinitionModel) o;

        if (offset != that.offset) return false;
        if (filename != null ? !filename.equals(that.filename) : that.filename != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (filename != null ? filename.hashCode() : 0);
        result = 31 * result + offset;
        return result;
    }

    @Override
    public String toString() {
        return "SubstepDefinitionModel{" +
                "text='" + text + '\'' +
                ", filename='" + filename + '\'' +
                ", offset=" + offset +
                '}';
    }
}
