package com.climbingApp.controller;

import com.climbingApp.dto.MemberDTO;
import com.climbingApp.service.AdminService;

import java.util.Scanner;

public class MenuController {
    AdminService adminService = new AdminService();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // printMenu() 호출

        MenuController menuController = new MenuController();
        menuController.printMenu();
    }

    // 관리자 메뉴 메뉴표시(회원등록)
    // AdminService() 호출 회원등록 프로세스 진행

    public void printMenu() {
        while (true) {
            System.out.println("======== 사용자를 입력해주세요 ========");
            System.out.println("1. 관리자");
            System.out.println("2. 회원");
            System.out.println("3. 강사");
            System.out.println("9. 프로그램종료");

            System.out.print("메뉴 번호 선택 : ");
            int num = sc.nextInt();

            switch (num) {
                case 1:
                    Scanner sc = new Scanner(System.in);

                    String adminId = "admin";
                    String adminPwd = "admin";

                    System.out.print("아이디 : ");
                    String id = sc.next();
                    System.out.print("비밀번호 : ");
                    String pwd = sc.next();

                    if (id.equals(adminId) && pwd.equals(adminPwd)) {
                        System.out.println("관리자메뉴로 이동합니다. ");
                        adminMenu();
                    } else {
                        System.out.println("권한이 없습니다.");
                        break;
                    }
                case 2:
                    System.out.println("회원메뉴로 이동합니다.");
                    return;
                case 3:
                    System.out.println("강사메뉴로 이동합니다.");
                    return;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
        }
    }

    // 관리자 메뉴
    public void adminMenu() {

        while (true) {

            System.out.println("======== 실내 암벽 등반 센터 ========");
            System.out.println("1. 회원가입");
            System.out.println("2. 회원조회");
            System.out.println("3. 회원수정");
            System.out.println("9. 프로그램종료");

            System.out.print("메뉴 번호 선택 : ");
            int num = sc.nextInt();

            switch (num) {
                case 1:
                    adminService.inputMember(); // 회원등록 메서드실행
                    break;

                case 2:
                    selectMemberMenu(); // 회원조회 메뉴출력
                    break;
                case 3:
                    updateMemberMenu(); // 회원수정 메뉴출력
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
        }
    }

    // 회원조회메뉴
    public void selectMemberMenu() {
        System.out.println("1. 전체회원조회");
        System.out.println("2. 회원한명조회");

        System.out.print("메뉴 번호 선택 : ");
        int num = sc.nextInt();

        switch (num) {
            case 1:
                adminService.selectAllMember(); // 회원전체조회 메서드실행
                break;

            case 2:
                adminService.selectOneMember(adminService.inputMemberPhone()); // 회원한명조회 메서드실행
                break;
        }
    }

    // 회원수정메뉴
    public void updateMemberMenu() {
        System.out.println("1. 회원이름수정");
        System.out.println("2. 회원센터수정");
        System.out.println("3. 회원성별수정");
        System.out.println("4. 회원나이수정");
        System.out.println("5. 회원탈퇴");

        System.out.print("메뉴 번호 선택 : ");
        int num = sc.nextInt();

        switch (num) {
            case 1: // 회원이름변경 메서드 실행
                adminService.updateMemberName(adminService.inputMemberPhone(), adminService.inputMemberName());
                break;
            case 2: // 회원센터변경 메서드 실행
                adminService.updateMemberCenter(adminService.inputMemberPhone(), adminService.inputCenter());
                break;
            case 3: // 회원성별변경 메서드 실행
                adminService.updateMemberGender(adminService.inputMemberPhone(), adminService.inputMemberGender());
                break;
            case 4: // 회원나이변경 메서드 실행
                adminService.updateMemberAge(adminService.inputMemberPhone(), adminService.inputMemberAge());
                break;
            case 5: // 회원탈퇴 메서드 실행
                adminService.deleteMember(adminService.inputMemberPhone());
                break;
        }
    }


}
