package com.technophobia.substeps.model.syntax;

import com.technophobia.substeps.model.exception.StepImplementationException;
import com.technophobia.substeps.model.exception.SubstepParsingException;

import java.io.File;

public interface IdeaSyntaxErrorReporter {

    void reportFeatureError(File file, String line, int lineNumber, int offset, String description)
            throws RuntimeException;


    void reportFeatureError(File file, String line, int lineNumber, int offset, String description, RuntimeException ex)
            throws RuntimeException;


    void reportSubstepsError(SubstepParsingException ex);


    void reportStepImplError(StepImplementationException ex);
}