package com.climbingApp.dto;

public class MembershipDTO {

    public int memberShipNo;
    public int memberShipPrice;
    public int memberShipDuration;

    public MembershipDTO() {
    }

    public MembershipDTO(int memberShipNo, int memberShipPrice, int memberShipDuration) {
        this.memberShipNo = memberShipNo;
        this.memberShipPrice = memberShipPrice;
        this.memberShipDuration = memberShipDuration;
    }

    public int getMemberShipNo() {
        return memberShipNo;
    }

    public void setMemberShipNo(int memberShipNo) {
        this.memberShipNo = memberShipNo;
    }

    public int getMemberShipPrice() {
        return memberShipPrice;
    }

    public void setMemberShipPrice(int memberShipPrice) {
        this.memberShipPrice = memberShipPrice;
    }

    public int getMemberShipDuration() {
        return memberShipDuration;
    }

    public void setMemberShipDuration(int memberShipDuration) {
        this.memberShipDuration = memberShipDuration;
    }

    @Override
    public String toString() {
        return "memberShipNo=" + memberShipNo +
                ", memberShipPrice=" + memberShipPrice +
                ", memberShipDuration=" + memberShipDuration;
    }
}
