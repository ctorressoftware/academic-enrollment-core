package io.github.ctorressoftware.academic.enrollment.person.domain.model;

public enum DocumentType {
    DNI((short) 1, "DNI"),
    PASSPORT((short) 2, "PASSPORT");

    private final short id;
    private final String code;

    DocumentType(short id, String code) {
        this.id = id;
        this.code = code;
    }

    public short getId() {
        return id;
    }

    public String getCode() {
        return code;
    }
}
