package com.justdo.climbing.view;

import com.justdo.climbing.constant.AuthorityCode;
import com.justdo.climbing.controller.ClimbingController;
import com.justdo.climbing.service.AdminService;
import com.justdo.climbing.service.ClientService;
import com.justdo.climbing.service.InstructorService;

public class ClimbingMainMenu {

    private ClimbingController controller = new ClimbingController();
    private AdminService adminService = new AdminService();
    private AuthorityCode authorityCode;
    private InstructorService instructorService = new InstructorService();
    private ClientService clientService = new ClientService();

    /**
     * 권한 선택메뉴 테스트확인
     * */
    public void AuthorityMenu(){
        boolean isTrue = true;
        while(isTrue) {
            System.out.println("""
                =================================
                안녕하세요.
                신세계 클라이밍 센터입니다.
                사용자 정보를 선택해 주세요.
                1. 관리자
                2. 강사
                3. 고객
                9. 종료
                ==================================
                """);
            int authority = controller.selectMenuNum();
            switch (authority) {
                case 1:
                    authorityCode = AuthorityCode.ADMIN;
                    System.out.println(authorityCode.getDescription() + " 을(를) 선택했습니다.");
                    AdminMenu();
                    break;
                case 2:
                    authorityCode = AuthorityCode.INSTRUCTOR;
                    System.out.println(authorityCode.getDescription() + " 을(를) 선택했습니다.");
                    InstructorMenu();
                    break;
                case 3:
                    authorityCode = AuthorityCode.CLIENT;
                    System.out.println(authorityCode.getDescription() + " 을(를) 선택했습니다.");
                    ClientMenu();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    isTrue = false;
                    break;
                default:
                    System.out.println("잘못된 숫자를 입력했습니다. 다시 입력해 주세요");
                    break;
            }
        }

    }

    /**
     * 로그인 전 관리자 메뉴
     * */
    public void AdminMenu(){
        while(true){
            System.out.println("""
                    =========================================
                    관리자 메뉴
                    1. 로그인
                    9. 뒤로가기
                    =========================================
                    """);
            int num = controller.selectMenuNum();
            switch (num){
                case 1:
                    // 로그인 메소드 호출
                    // 완료후 로그인후 페이지 호출
                    if(!controller.logIn(authorityCode.getDescription()).isBlank()) {
                        AdminMenu_login();
                    }
                    break;
                case 9:
                    System.out.println("이전화면으로 되돌아갑니다.");
                    return;
            }
        }
    }

    /**
     * 로그인 후 관리자 메뉴
     * */
    public void AdminMenu_login() {
        while(true){
            System.out.println("""
                        =========================================
                        관리자 전용 도메인 입니다.
                        메뉴를 선택해 주세요.
                        1. 회원 등록
                        2. 강사 등록
                        3. 회원 정보 수정
                        4. 강사 정보 수정
                        5. 회원 정보 조회
                        6. 강사 정보 조회
                        7. 물품 관리
                        9. 로그아웃
                        =========================================
                    """);
            int num = controller.selectMenuNum();
            switch (num){
                case 1:
                    // 회원등록 메소드 호출
                    adminService.inputMember();
                    break;
                case 2:
                    // 강사 등록 메소드 호출
                    adminService.AddInstructorInfo();
                    break;
                case 3:
                    // 회원 정보 수정 메소드 호출

                    adminService.updateMemberMenu();
                    break;
                case 4:
                    // 강사 정보 수정 메소드 호출
                    adminService.EditInstructorInfo();
                    break;
                case 5:
                    // 회원 정보 조회 메소드 호출
                    adminService.selectMemberMenu();
                    break;
                case 6:
                    // 강사 정보 조회 메소드 호출
                    adminService.PrintInstructorInfo();
                    break;
                case 7:
                    // 물품관리 메소드 호출
                    break;
                case 9:
                    System.out.println("로그아웃을 완료했습니다.");
                    return;
                default:
                    System.out.println("잘못된 숫자를 입력했습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }

    /**
     * 로그인 전 강사 메뉴
     * */
    public void InstructorMenu(){
        while(true){
            // 로그인 미진행 시 아래 화면
            System.out.println("""
                    =========================================
                    강사전용 도메인 입니다.
                    메뉴를 선택해 주세요.
                    1. 로그인
                    9. 뒤로가기
                    =========================================
                    """);
            int num = controller.selectMenuNum();
            switch (num){
                case 1:
                    // 로그인 완료시 아래 메소드 호출
                    String id = controller.logIn(authorityCode.getDescription());
                    if (!id.isBlank()) {
                        InstructorMenu_login(id);
                    }
                    break;
                case 9:
                    // 로그인을 안했으면
                    System.out.println("이전화면으로 되돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못된 숫자를 입력했습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }

    /**
     * 로그인 후 강사메뉴
     * */
    public void InstructorMenu_login(String id){
        while(true) {
            System.out.println("""
                    =========================================
                    강사전용 도메인 입니다.
                    메뉴를 선택해 주세요.
                    1. 내 정보
                    2. 회원 조회
                    9. 로그아웃
                    =========================================
                    """);
            int num = controller.selectMenuNum();
            switch (num){
                case 1:
                    // 로그인 완료 후 내 정보 불러오기 (준영)
                    instructorService.printInstructorInfo(id);
                    break;
                case 2:
                    instructorService.printClientInfoToInstructor();
                    break;
                case 9:
                    System.out.println("로그아웃을 완료했습니다.");
                    return;
                default:
                    System.out.println("잘못된 숫자를 입력했습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }


    /**
     * 로그인 전 회원 메뉴
     * */
    public void ClientMenu(){

        // TODO:DTO가 이동하는것이아닌 hp 또는 식별값만 이동하도록 수정필요
        while(true){
            // 회원 객체가 null이면 => 로그인을 아직 안했으면 (조건절)
            System.out.println("""
                    =========================================
                    회원전용 도메인 입니다.
                    메뉴를 선택해 주세요.
                    1. 회원가입
                    2. 로그인
                    9. 뒤로가기
                    =========================================
                    """);
            int num = controller.selectMenuNum();
            switch (num){
                case 1:
                    // 회원가입 메소드 호출
                    clientService.AddClientInfo();
                    break;
                case 2:
                    // 로그인 메소드 호출
                    String cleintID= controller.logIn(authorityCode.getDescription());
                    if (!cleintID.isBlank()) {
                        ClientMenu_login(cleintID);
                    }
                    break;
                case 9:
                    System.out.println("이전화면으로 되돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못된 숫자를 입력했습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }

    /**
     * 로그인 후 회원 메뉴
     * */
    public void ClientMenu_login(String id){
        while(true){
            System.out.println("""
                    =========================================
                    고객전용 도메인 입니다.
                    메뉴를 선택해 주세요.
                    1. 내정보
                    2. 회원권 구매
                    3. 물품 구매
                    4. 입장하기
                    9. 로그아웃
                    =========================================
                    """);
            int num = controller.selectMenuNum();
            switch (num){
                case 1:
                    // 내정보 불러오기 메소드
                    clientService.printClientInfo(id);
                    break;
                case 2:
                    // 회원권 구매 메소드
                    clientService.purchase(id);
                    break;
                case 3:
                    // 물품 구매 메소드
                    break;
                case 4:
                    // 입장하기 메소드 호출
                    break;
                case 9:
                    System.out.println("로그아웃을 완료했습니다.");
                    return;
                default:
                    System.out.println("잘못된 숫자를 입력했습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }
}
