package com.technophobia.substeps.psi.substepsdefinition.impl;

import com.intellij.lang.ASTNode;
import com.technophobia.substeps.psi.substepsdefinition.SubstepsDefinitionTypes;
import generated.psi.SubstepsDefinitionDefinition;

public class SubstepsDefinitionPsiImplUtil {

    public static String getDefinitionText(SubstepsDefinitionDefinition element){
        ASTNode textNode = element.getNode().findChildByType(SubstepsDefinitionTypes.DEFINITION_TEXT);
        return textNode != null ? textNode.getText() : null;
    }
}
