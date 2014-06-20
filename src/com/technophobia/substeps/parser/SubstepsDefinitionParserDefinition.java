package com.technophobia.substeps.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.technophobia.substeps.language.SubstepsDefinitionLanguage;
import com.technophobia.substeps.lexer.substepsdefinition.SubstepsDefinitionLexer;
import com.technophobia.substeps.parser.substepsdefinition.SubstepsParser;
import com.technophobia.substeps.psi.SubstepsDefinitionFile;
import com.technophobia.substeps.psi.substepsdefinition.SubstepsDefinitionTypes;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;

public class SubstepsDefinitionParserDefinition implements ParserDefinition {
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(SubstepsDefinitionTypes.COMMENT);

    public static final IFileElementType FILE = new IFileElementType(Language.<SubstepsDefinitionLanguage>findInstance(SubstepsDefinitionLanguage.class));

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new FlexAdapter(new SubstepsDefinitionLexer((Reader)null));
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @Override
    public PsiParser createParser(Project project) {
        return new SubstepsParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new SubstepsDefinitionFile(viewProvider);
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return SubstepsDefinitionTypes.Factory.createElement(node);
    }
}
