package com.technophobia.substeps.search.substepsdefinition;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import com.technophobia.substeps.language.substepsdefinition.SubstepsDefinitionFileType;
import com.technophobia.substeps.model.SubstepsModel;
import com.technophobia.substeps.psi.SubstepsDefinitionFile;
import com.technophobia.substeps.psi.substepsdefinition.impl.SubstepsDefinitionPsiImplUtil;
import generated.psi.SubstepsDefinitionDefinition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SubstepDefinitionSearchUtil {

    public static com.google.common.base.Optional<com.technophobia.substeps.model.Patterned> findDefinition(final Project project, final String text){

        return SubstepsModel.INSTANCE.findMatchingDefinitionsFor(project, text);

//        final Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, SubstepsDefinitionFileType.INSTANCE, GlobalSearchScope.allScope(project));
//
//        for(final VirtualFile virtualFile : virtualFiles){
//            final SubstepsDefinitionFile definitionFile = (SubstepsDefinitionFile) PsiManager.getInstance(project).findFile(virtualFile);
//            if(definitionFile != null){
//                final SubstepsDefinitionDefinition[] definitions = PsiTreeUtil.getChildrenOfType(definitionFile, SubstepsDefinitionDefinition.class);
//                if(definitions != null){
//                    for(final SubstepsDefinitionDefinition definition : definitions){
//                        if(text.equals(definition.getText())){
//                            results.add(definition);
//                        }
//                    }
//                }
//            }
//        }
    }

}
