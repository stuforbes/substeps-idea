package com.technophobia.substeps.model;

import com.intellij.psi.PsiClass;

public class SubstepImplementationModel implements Patterned{

    private final String text;
    private final PsiClass javaClass;
    private final String methodName;

    public SubstepImplementationModel(String text, PsiClass javaClass, String methodName) {
        this.text = text.trim();
        this.javaClass = javaClass;
        this.methodName = methodName;
    }

    public String getText() {
        return text;
    }

    public PsiClass getJavaClass() {
        return javaClass;
    }

    public String getMethodName() {
        return methodName;
    }

    @Override
    public String pattern() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubstepImplementationModel that = (SubstepImplementationModel) o;

        if (javaClass != null ? !javaClass.equals(that.javaClass) : that.javaClass != null) return false;
        if (methodName != null ? !methodName.equals(that.methodName) : that.methodName != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (javaClass != null ? javaClass.hashCode() : 0);
        result = 31 * result + (methodName != null ? methodName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SubstepImplementationModel{" +
                "text='" + text + '\'' +
                ", javaClass=" + javaClass +
                ", methodName='" + methodName + '\'' +
                '}';
    }
}
