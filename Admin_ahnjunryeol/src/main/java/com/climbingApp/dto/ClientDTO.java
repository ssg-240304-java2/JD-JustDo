package com.climbingApp.dto;

import com.climbingApp.dto.MemberDTO;

public class ClientDTO extends MemberDTO {
    public int duration;
    public int instructorNo;

    public ClientDTO() {
    }

    public ClientDTO(String memberName, String memberPhone, int center, boolean memberGender, int memberAge, int duration, int instructorNo) {
        super(memberName, memberPhone, center, memberGender, memberAge);
        this.duration = duration;
        this.instructorNo = instructorNo;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getInstructorNo() {
        return instructorNo;
    }

    public void setInstructorNo(int instructorNo) {
        this.instructorNo = instructorNo;
    }

    @Override
    public String toString() {
        return super.toString() +
                "duration=" + duration +
                ", instructorNo=" + instructorNo;
    }

}
