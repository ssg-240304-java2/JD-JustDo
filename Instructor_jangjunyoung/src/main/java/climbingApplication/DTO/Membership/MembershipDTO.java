package climbingApplication.DTO.Membership;

public class MembershipDTO {
    private int memberShipNo;
    private int memberShipPrice;
    private int memberShipDuration;

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
}
