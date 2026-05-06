package com.vti.entity;

public class TypeQuestion {
    private int typeId;
    private TypeName typeName;

    public TypeQuestion() {
    }

    public enum TypeName {
        ESSAY, MULTIPLE_CHOICE
    }

    public TypeQuestion(int typeId, TypeName typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public TypeName getTypeName() {
        return typeName;
    }
}