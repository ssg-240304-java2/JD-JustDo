package com.climbingApp.dto;

import com.climbingApp.dto.MemberDTO;

public class IndustructorDTO extends MemberDTO {
    public int instructorNo;
    public char instructorGrade;

    public IndustructorDTO() {
    }

    public IndustructorDTO(String memberName, String memberPhone, int center, boolean memberGender, int memberAge, int instructorNo, char instructorGrade) {
        super(memberName, memberPhone, center, memberGender, memberAge);
        this.instructorNo = instructorNo;
        this.instructorGrade = instructorGrade;
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

    @Override
    public String toString() {
        return super.toString() +
                "instructorNo=" + instructorNo +
                ", instructorGrade=" + instructorGrade;
    }
}
