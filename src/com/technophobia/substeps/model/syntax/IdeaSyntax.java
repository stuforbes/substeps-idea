package com.technophobia.substeps.model.syntax;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.intellij.openapi.util.Pair;
import com.technophobia.substeps.model.PatternIdentifiedPsiElement;
import com.technophobia.substeps.model.PatternMap;
import com.technophobia.substeps.model.SubstepDefinitionModel;
import com.technophobia.substeps.model.SubstepImplementationModel;
import com.technophobia.substeps.model.exception.StepImplementationException;
import com.technophobia.substeps.model.exception.SubstepParsingException;

import java.util.Collection;
import java.util.Collections;
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

    public Optional<PatternIdentifiedPsiElement> stepImplementationMatching(final String pattern){
        return Optional.fromNullable((PatternIdentifiedPsiElement)stepImplementations.getValueForPattern(pattern));
    }

    public Optional<PatternIdentifiedPsiElement> substepDefinitionMatching(final String pattern){
        return Optional.fromNullable((PatternIdentifiedPsiElement)substepDefinitions.getValueForPattern(pattern));
    }

    public Collection<? extends PatternIdentifiedPsiElement> allStepImplementations() {
        return Collections.unmodifiableCollection(stepImplementations.values());
    }

    public Collection<? extends PatternIdentifiedPsiElement> allSubstepDefinitions() {
        return Collections.unmodifiableCollection(substepDefinitions.values());
    }

    private static <T extends PatternIdentifiedPsiElement> PatternMap<T> toPatternMap(final List<T> items, Function<Pair<String, T>, Void> onError) {
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
