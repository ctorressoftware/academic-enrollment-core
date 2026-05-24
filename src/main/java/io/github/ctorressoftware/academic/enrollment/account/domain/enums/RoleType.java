package io.github.ctorressoftware.academic.enrollment.account.domain.enums;

public enum RoleType {
    ADMIN((short) 1),
    TEACHER((short) 2),
    STUDENT((short) 3);

    private final short id;

    RoleType(short id) {
        this.id = id;
    }

    public short getId() {
        return id;
    }
}
