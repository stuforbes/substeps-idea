package com.technophobia.substeps.reference.feature;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import com.technophobia.substeps.reference.SubstepsReference;
import generated.psi.*;
import org.jetbrains.annotations.NotNull;

public class FeatureReferenceContributor extends PsiReferenceContributor{

    @Override
    public void registerReferenceProviders(PsiReferenceRegistrar registrar) {
        PsiReferenceProvider referenceProvider = new PsiReferenceProvider() {
            @NotNull
            @Override
            public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {

                final String stepLine = element.getText();
                TextRange textRange = nonWhitespaceTextRange(stepLine);

                return new PsiReference[]{new SubstepsReference(element, textRange)};
            }
        };
        registerReferenceProvider(FeatureBackgroundStepLine.class, registrar, referenceProvider);
        registerReferenceProvider(FeatureScenarioStepLine.class, registrar, referenceProvider);
        registerReferenceProvider(FeatureScenarioOutlineStepLine.class, registrar, referenceProvider);
    }

    private void registerReferenceProvider(final Class<? extends PsiElement> stepLineClass, final PsiReferenceRegistrar registrar, final PsiReferenceProvider referenceProvider) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(stepLineClass), referenceProvider);
    }

    private TextRange nonWhitespaceTextRange(String stepLine) {
        int start = 0, end = stepLine.length()-1;
        for(int i=0; i<stepLine.length(); i++){
            if(Character.isWhitespace(stepLine.charAt(i))){
                start++;
            } else{
                break;
            }
        }
        for(int i=stepLine.length()-1; i>=0; i--){
            if(Character.isWhitespace(stepLine.charAt(i))){
                end--;
            } else{
                break;
            }
        }
        return new TextRange(start, end);
    }
}
