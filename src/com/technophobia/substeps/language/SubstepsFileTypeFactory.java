package com.technophobia.substeps.language;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import com.technophobia.substeps.language.feature.FeatureFileType;
import com.technophobia.substeps.language.substepsdefinition.SubstepsDefinitionFileType;
import org.jetbrains.annotations.NotNull;

public class SubstepsFileTypeFactory extends FileTypeFactory {

    @Override
    public void createFileTypes(@NotNull FileTypeConsumer consumer) {
        consumer.consume(SubstepsDefinitionFileType.INSTANCE, "substeps");
        consumer.consume(FeatureFileType.INSTANCE, "feature");
    }
}
