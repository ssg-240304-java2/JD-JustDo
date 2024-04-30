package com.justdo.climbing.dto.member;

public class MemberDTO {
    private String memberName;
    private String memberPhone;
    private int center;
    private boolean memberGender;
    private int memberAge;

    public MemberDTO() {
    }

    public MemberDTO(String memberName, String memberPhone, int center, boolean memberGender, int memberAge) {
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.center = center;
        this.memberGender = memberGender;
        this.memberAge = memberAge;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public int getCenter() {
        return center;
    }

    public void setCenter(int center) {
        this.center = center;
    }

    public boolean isMemberGender() {
        return memberGender;
    }

    public void setMemberGender(boolean memberGender) {
        this.memberGender = memberGender;
    }

    public int getMemberAge() {
        return memberAge;
    }

    public void setMemberAge(int memberAge) {
        this.memberAge = memberAge;
    }

    @Override
    public String toString() {
        return
                "memberName='" + memberName + '\'' +
                ", memberPhone='" + memberPhone + '\'' +
                ", center=" + center +
                ", memberGender=" + memberGender +
                ", memberAge=" + memberAge ;
    }
}
