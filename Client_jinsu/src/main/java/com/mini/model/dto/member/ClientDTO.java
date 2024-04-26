package com.mini.model.dto.member;

public class ClientDTO extends MemberDTO{
    private int duration;
    private int instructorNo;

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public int getInstructorNo() {
        return instructorNo;
    }

    public ClientDTO() {
    }

    public ClientDTO(String memberName, String memberPhone, int center, boolean memberGender, int memberAge) {
        super(memberName, memberPhone, center, memberGender, memberAge);
    }

    public ClientDTO(String memberName, String memberPhone, int center, boolean memberGender, int memberAge, int duration, int instructorNo) {
        super(memberName, memberPhone, center, memberGender, memberAge);
        this.duration = duration;
        this.instructorNo = instructorNo;
    }
}
