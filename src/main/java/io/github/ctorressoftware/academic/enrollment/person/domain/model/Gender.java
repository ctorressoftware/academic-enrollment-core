package io.github.ctorressoftware.academic.enrollment.person.domain.model;

public enum Gender {
    MALE(1, "M"),
    FEMALE(2, "F");

    private final int id;
    private final String code;

    Gender(int id, String code) {
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
