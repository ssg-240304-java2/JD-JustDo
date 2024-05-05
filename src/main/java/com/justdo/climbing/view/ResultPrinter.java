package com.justdo.climbing.view;

public class ResultPrinter {

    /**
     * 에러메세지를 출력하는 메소드
     * @param 출력할 메세지 종류
     * */
    public void errorPage(String msg) {
        switch (msg) {
            case "insertMember":
                System.out.println("회원정보 등록 실패...");
                break;
            case "selectAllMember":
                System.out.println("회원정보 조회 실패...");
                break;
            case "updateMember":
                System.out.println("회원정보 수정 실패...");
                break;
            case "usedPhone":
                System.out.println("이미 등록되어있는 핸드폰번호입니다. 다른 핸드폰번호를 입력해주세요.");
                break;
        }

    }

    /**
     * 성공메세지를 출력하는 메소드
     * @param 출력할 메세지 종류
     * */
    public void successPage(String msg) {
        switch (msg) {
            case "insertMember":
                System.out.println("회원정보 등록 성공!!!");
                break;
            case "selectAllMember":
                System.out.println("회원정보 조회 성공!!!");
                break;
            case "updateMember":
                System.out.println("회원정보 수정 성공!!!");
                break;
            case "availablePhone":
                System.out.println("사용가능한 핸드폰번호입니다. 회원정보를 등록해주세요.");
                break;
        }
    }

}
