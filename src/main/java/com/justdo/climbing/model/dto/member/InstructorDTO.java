package com.justdo.climbing.model.dto.member;

public class InstructorDTO extends MemberDTO{
    private int instructorNo;
    private char instructorGrade;

    public InstructorDTO() {
    }

    public int getInstructorNo() {
        return instructorNo;
    }

    public void setInstructorNo(int instructorNo) {
        this.instructorNo = instructorNo;
    }

    public char getInstructorGrade() {
        return instructorGrade;
    }

    public void setInstructorGrade(char instructorGrade) {
        this.instructorGrade = instructorGrade;
    }

    public InstructorDTO(String memberName, String memberPhone, boolean memberGender, int memberAge, int instructorNo, char instructorGrade) {
        super(memberName, memberPhone,memberGender, memberAge);
        this.instructorNo = instructorNo;
        this.instructorGrade = instructorGrade;
    }

    @Override
    public String toString() {
        return super.toString() + "instructorNo=" + instructorNo +
                ", instructorGrade=" + instructorGrade;
    }
}
