package com.technophobia.substeps.model.exception;

import com.intellij.psi.PsiClass;

public class SubstepParsingException extends SubstepsException {

    private final String filename;
    private final int offset;

    public SubstepParsingException(final String filename, final int offset,
                            final String message) {
        super(message);
        this.filename = filename;
        this.offset = offset;
    }

    public String getFilename() {
        return filename;
    }

    public int getOffset() {
        return offset;
    }
}
