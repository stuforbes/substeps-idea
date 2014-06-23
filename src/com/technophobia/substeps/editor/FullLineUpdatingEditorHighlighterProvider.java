package com.technophobia.substeps.editor;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.highlighter.EditorHighlighter;
import com.intellij.openapi.editor.highlighter.EditorHighlighterFactory;
import com.intellij.openapi.editor.highlighter.HighlighterClient;
import com.intellij.openapi.editor.highlighter.HighlighterIterator;
import com.intellij.openapi.editor.impl.event.DocumentEventImpl;
import com.intellij.openapi.fileTypes.EditorHighlighterProvider;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Implementation of {@link com.intellij.openapi.fileTypes.EditorHighlighterProvider} which creates an {@link com.intellij.openapi.editor.highlighter.EditorHighlighter}
 * implementation that intercepts beforeDocumentChange and documentChanged events in the {@link javax.swing.event.DocumentListener} event handler, and updates the start offset
 * parameter to be the beginning of that line
 */
public class FullLineUpdatingEditorHighlighterProvider implements EditorHighlighterProvider {
    @Override
    public EditorHighlighter getEditorHighlighter(@Nullable Project project, @NotNull FileType fileType, @Nullable VirtualFile virtualFile, @NotNull EditorColorsScheme colors) {
        final EditorHighlighter delegate = EditorHighlighterFactory.getInstance().createEditorHighlighter(
                SyntaxHighlighterFactory.getSyntaxHighlighter(fileType, project, virtualFile), colors);

        return new EditorHighlighter() {
            @NotNull
            @Override
            public HighlighterIterator createIterator(int startOffset) { return delegate.createIterator(startOffset); }

            @Override
            public void setText(@NotNull CharSequence text) { delegate.setText(text); }

            @Override
            public void setEditor(@NotNull HighlighterClient editor) { delegate.setEditor(editor); }

            @Override
            public void setColorScheme(@NotNull EditorColorsScheme scheme) { delegate.setColorScheme(scheme); }

            @Override
            public void beforeDocumentChange(DocumentEvent event) { delegate.beforeDocumentChange(eventWithStartOfLineOffset(event)); }

            @Override
            public void documentChanged(DocumentEvent event) {
                delegate.documentChanged(eventWithStartOfLineOffset(event));
            }
        };
    }

    private DocumentEvent eventWithStartOfLineOffset(DocumentEvent event) {
        final Document document = event.getDocument();
        final int offset = event.getOffset();

        final String substring = document.getText().substring(0, offset);
        final int newOffset = substring.lastIndexOf('\n') > -1 ? substring.lastIndexOf('\n') + 1 : 0;

        return new DocumentEventImpl(document, newOffset, event.getOldFragment(), event.getNewFragment(), event.getOldTimeStamp(), event.isWholeTextReplaced());
    }
}
