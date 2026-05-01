package io.github.ctorressoftware.academic.enrollment.person.domain.model;

public enum DocumentType {
    DNI(1, "DNI"),
    PASSPORT(2, "PASSPORT");

    private final int id;
    private final String code;

    DocumentType(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }
}
