package com.mini.model.dto.member;

public class MemberShipDTO {
    private int memberShipNo;
    private int memberShipPrice;
    private int MemberShipDuration;

    public int getMemberShipNo() {
        return memberShipNo;
    }

    public int getMemberShipPrice() {
        return memberShipPrice;
    }

    public int getMemberShipDuration() {
        return MemberShipDuration;
    }

    public MemberShipDTO() {
    }

    public MemberShipDTO(int memberShipNo, int memberShipPrice, int memberShipDuration) {
        this.memberShipNo = memberShipNo;
        this.memberShipPrice = memberShipPrice;
        MemberShipDuration = memberShipDuration;
    }
}
