package com.technophobia.substeps.model.syntax;

import com.intellij.openapi.diagnostic.Logger;
import com.technophobia.substeps.model.exception.StepImplementationException;
import com.technophobia.substeps.model.exception.SubstepParsingException;
import com.technophobia.substeps.model.exception.SubstepsParsingException;
import com.technophobia.substeps.runner.syntax.SyntaxErrorReporter;

import java.io.File;

public class DefaultIdeaSyntaxErrorReporter implements IdeaSyntaxErrorReporter {

    private static final Logger LOG = Logger.getInstance(DefaultIdeaSyntaxErrorReporter.class);


    public void reportFeatureError(final File file, final String line, final int lineNumber, final int offset,
                                   final String description) throws RuntimeException {
        LOG.error("Error on line " + lineNumber + " of feature file " + file.getAbsolutePath() + ": " + line
                + " - reason: " + description);
    }


    public void reportFeatureError(final File file, final String line, final int lineNumber, final int offset,
                                   final String description, final RuntimeException ex) throws RuntimeException {
        LOG.error("Error on line " + lineNumber + " of feature file " + file.getAbsolutePath() + ": " + line
                + " - reason: " + description);
        throw ex;
    }


    public void reportSubstepsError(final SubstepParsingException ex) {
        LOG.error(ex.getMessage());
    }


    public void reportStepImplError(final StepImplementationException ex) {
        LOG.error(ex.getMessage());
    }

}