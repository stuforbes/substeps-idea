package com.technophobia.substeps.model.syntax;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.intellij.openapi.util.Pair;
import com.technophobia.substeps.model.PatternMap;
import com.technophobia.substeps.model.Patterned;
import com.technophobia.substeps.model.SubstepDefinitionModel;
import com.technophobia.substeps.model.SubstepImplementationModel;
import com.technophobia.substeps.model.exception.StepImplementationException;
import com.technophobia.substeps.model.exception.SubstepParsingException;

import java.util.List;

public class IdeaSyntax {

    // These two will always be populated
    private final PatternMap<SubstepImplementationModel> stepImplementations;

    private final PatternMap<SubstepDefinitionModel> substepDefinitions;


    private final IdeaSyntaxErrorReporter syntaxErrorReporter;

    public IdeaSyntax(final List<SubstepImplementationModel> stepImplementations, final List<SubstepDefinitionModel> substepDefinitions) {
        this(stepImplementations, substepDefinitions, new DefaultIdeaSyntaxErrorReporter());
    }

    public IdeaSyntax(final List<SubstepImplementationModel> stepImplementations, final List<SubstepDefinitionModel> substepDefinitions, final IdeaSyntaxErrorReporter syntaxErrorReporter) {
        this.stepImplementations = toPatternMap(stepImplementations, stepImplError(syntaxErrorReporter));
        this.substepDefinitions = toPatternMap(substepDefinitions, substepError(syntaxErrorReporter));
        this.syntaxErrorReporter = syntaxErrorReporter;
    }

    public Optional<Patterned> stepImplementationMatching(final String pattern){
        return Optional.fromNullable((Patterned)stepImplementations.getValueForPattern(pattern));
    }

    public Optional<Patterned> substepDefinitionMatching(final String pattern){
        return Optional.fromNullable((Patterned)substepDefinitions.getValueForPattern(pattern));
    }


    private static <T extends Patterned> PatternMap<T> toPatternMap(final List<T> items, Function<Pair<String, T>, Void> onError) {
        final PatternMap<T> patternMap = new PatternMap<T>();
        for (final T item : items) {

            if (!patternMap.containsPattern(item.pattern())) {
                patternMap.put(item.pattern(), item);
            } else {
                onError.apply(new Pair<String, T>("Couldn't add pattern " + item.pattern() + ", as it already exists", item));
            }
        }
        return patternMap;
    }

    private static Function<Pair<String, SubstepImplementationModel>, Void> stepImplError(final IdeaSyntaxErrorReporter syntaxErrorReporter){
        return new Function<Pair<String, SubstepImplementationModel>, Void>() {
            @Override
            public Void apply(Pair<String, SubstepImplementationModel> messageAndStepImpl) {
                final String message = messageAndStepImpl.getFirst();
                final SubstepImplementationModel stepImpl = messageAndStepImpl.getSecond();
                syntaxErrorReporter.reportStepImplError(new StepImplementationException(stepImpl.getJavaClass(), stepImpl.getMethodName(), message));
                return null;
            }
        };
    }
    private static Function<Pair<String, SubstepDefinitionModel>, Void> substepError(final IdeaSyntaxErrorReporter syntaxErrorReporter){
        return new Function<Pair<String, SubstepDefinitionModel>, Void>() {
            @Override
            public Void apply(Pair<String, SubstepDefinitionModel> messageAndSubstep) {
                final String message = messageAndSubstep.getFirst();
                final SubstepDefinitionModel substep = messageAndSubstep.getSecond();
                syntaxErrorReporter.reportSubstepsError(new SubstepParsingException(substep.getFilename(), substep.getOffset(), message));
                return null;
            }
        };
    }
}
