package com.mini.model.dto.member;

public class MemberDTO {
    private String memberName;
    private String memberPhone;
    private int center;
    private boolean memberGender;
    private int MemberAge;

    public String getMemberName() {
        return memberName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public int getCenter() {
        return center;
    }

    public boolean isMemberGender() {
        return memberGender;
    }

    public int getMemberAge() {
        return MemberAge;
    }

    public MemberDTO() {
    }

    public MemberDTO(String memberName, String memberPhone, int center, boolean memberGender, int memberAge) {
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.center = center;
        this.memberGender = memberGender;
        this.MemberAge = memberAge;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberName='" + memberName + '\'' +
                ", memberPhone='" + memberPhone + '\'' +
                ", center=" + center +
                ", memberGender=" + memberGender +
                ", MemberAge=" + MemberAge +
                '}';
    }
}
