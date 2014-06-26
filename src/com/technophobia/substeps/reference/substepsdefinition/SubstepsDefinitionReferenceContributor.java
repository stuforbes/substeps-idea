package com.technophobia.substeps.reference.substepsdefinition;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import generated.psi.SubstepsDefinitionStepLine;
import org.jetbrains.annotations.NotNull;

public class SubstepsDefinitionReferenceContributor extends PsiReferenceContributor{

    public SubstepsDefinitionReferenceContributor(){
        System.out.println("Substeps reference contributor");
    }

    @Override
    public void registerReferenceProviders(PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(SubstepsDefinitionStepLine.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {

                        final String stepLine = element.getText();
                        TextRange textRange = nonWhitespaceTextRange(stepLine);

                        return new PsiReference[]{new SubstepsDefinitionReference(element, textRange)};
                    }
                });
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
