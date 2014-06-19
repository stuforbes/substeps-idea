package com.technophobia.substeps.model;

public class SubstepDefinitions {

    private final String text;
    private final String filename;
    private final int line;

    public SubstepDefinitions(String text, String filename, int line) {
        this.text = text;
        this.filename = filename;
        this.line = line;
    }

    public String getText() {
        return text;
    }

    public String getFilename() {
        return filename;
    }

    public int getLine() {
        return line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubstepDefinitions that = (SubstepDefinitions) o;

        if (line != that.line) return false;
        if (filename != null ? !filename.equals(that.filename) : that.filename != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (filename != null ? filename.hashCode() : 0);
        result = 31 * result + line;
        return result;
    }

    @Override
    public String toString() {
        return "SubstepDefinitions{" +
                "text='" + text + '\'' +
                ", filename='" + filename + '\'' +
                ", line=" + line +
                '}';
    }
}
