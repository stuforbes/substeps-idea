package com.technophobia.substeps.reference.substepsdefinition;

import com.intellij.find.impl.HelpID;
import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.lexer.FlexAdapter;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import com.technophobia.substeps.lexer.substepsdefinition.SubstepsDefinitionLexer;
import com.technophobia.substeps.psi.substepsdefinition.SubstepsDefinitionTypes;
import generated.psi.SubstepsDefinitionDefinition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Reader;

public class SubstepsDefinitionFindUsagesProvider implements FindUsagesProvider {

    private static final DefaultWordsScanner WORDS_SCANNER = new DefaultWordsScanner(
            new FlexAdapter(new SubstepsDefinitionLexer((Reader)null)),
            TokenSet.create(SubstepsDefinitionTypes.DEFINITION),
            TokenSet.create(SubstepsDefinitionTypes.COMMENT),
            TokenSet.EMPTY
    );

    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return WORDS_SCANNER;
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof PsiNamedElement;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return HelpID.FIND_IN_PROJECT;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        if(element instanceof SubstepsDefinitionDefinition){
            return "Substep";
        }
        return "";
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        if(element instanceof SubstepsDefinitionDefinition){
            String text = ((SubstepsDefinitionDefinition) element).getName();
            return text != null ? text : "";
        }
        return "";
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        if(element instanceof SubstepsDefinitionDefinition){
            String text = ((SubstepsDefinitionDefinition) element).getText();
            return text != null ? text : "";
        }
        return "";
    }
}
