package com.technophobia.substeps.editor.annotation.substepsdefinition;

import com.google.common.base.Optional;
import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.technophobia.substeps.model.PatternIdentifiedPsiElement;
import com.technophobia.substeps.search.substepsdefinition.SubstepDefinitionSearchUtil;
import com.technophobia.substeps.syntax.Colours;
import generated.psi.SubstepsDefinitionStepLine;
import org.jetbrains.annotations.NotNull;

public class SubstepsDefinitionAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if(element instanceof SubstepsDefinitionStepLine){
            SubstepsDefinitionStepLine stepDefinitionLine = (SubstepsDefinitionStepLine) element;

            String text = stepDefinitionLine.getText();
            if(text != null){
                final Project project = element.getProject();
                final Optional<PatternIdentifiedPsiElement> stepDefinition = SubstepDefinitionSearchUtil.findDefinition(project, text.trim());
                if(stepDefinition.isPresent()){
                    final Annotation annotation = holder.createInfoAnnotation(element.getTextRange(), null);
                    annotation.setEnforcedTextAttributes(Colours.VALID_STEP.attributes());
                } else {
                    holder.createErrorAnnotation(element.getTextRange(), "Unresolved step");
                }
            }
        }
    }
}
