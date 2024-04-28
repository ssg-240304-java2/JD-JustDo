package climbingApplication.ENUM;

public enum GradeEnum {
    A_GRADE('A'),
    B_GRADE('B'),
    C_GRADE('C');

    private final char description;

    GradeEnum(char description) {
        this.description = description;
    }

    public char getDescription() {
        return this.description;
    }
}
