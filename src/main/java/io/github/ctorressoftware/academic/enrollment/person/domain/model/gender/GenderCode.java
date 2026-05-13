package io.github.ctorressoftware.academic.enrollment.person.domain.model.gender;

public enum GenderCode {
    MALE(1, "M"),
    FEMALE(2, "F");

    private final int id;
    private final String code;

    GenderCode(int id, String code) {
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
