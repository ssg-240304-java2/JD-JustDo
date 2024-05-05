package com.justdo.climbing.dto.member;

public class ClientDTO extends MemberDTO{
    private int duration;
    private int instructorNo;

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

    public ClientDTO() {
    }

    public ClientDTO(String memberName, String memberPhone, boolean memberGender, int memberAge, int duration, int instructorNo) {
        super(memberName, memberPhone,memberGender, memberAge);
        this.duration = duration;
        this.instructorNo = instructorNo;
    }

    @Override
    public String toString() {
        return super.toString()  +
                "duration=" + duration +
                ", instructorNo=" + instructorNo ;
    }
}
