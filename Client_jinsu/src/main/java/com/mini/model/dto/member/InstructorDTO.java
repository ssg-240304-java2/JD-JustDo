package com.mini.model.dto.member;

public class InstructorDTO extends MemberDTO{
    private int instructorNo;
    private char instructorGrade;

    public int getInstructorNo() {
        return instructorNo;
    }

    public char getInstructorGrade() {
        return instructorGrade;
    }

    public InstructorDTO(String memberName, String memberPhone, int center, boolean memberGender, int memberAge, int instructorNo, char instructorGrade) {
        super(memberName, memberPhone, center, memberGender, memberAge);
        this.instructorNo = instructorNo;
        this.instructorGrade = instructorGrade;
    }
}
