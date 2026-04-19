public class TypeQuestion {
    private int typeId;
    private TypeName typeName;

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