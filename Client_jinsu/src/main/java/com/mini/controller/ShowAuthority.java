package com.mini.controller;

import java.util.Scanner;

public class ShowAuthority {
    private Scanner sc;

    public void showAuthority() {
        sc = new Scanner(System.in);
        LoginMenu login = new LoginMenu(); // LoginMenu 인스턴스 생성

        while (true) {
            System.out.println("""
                    ======================================
                    어서오세요. 일단해조 클라이밍장입니다.
                    ======================================
                    권한을 선택해주세요.
                    ======================================
                    1. 관리자
                    2. 강사
                    3. 회원
                    종료하시려면 ' 9 ' 를 눌러주세요
                    위의 숫자 중 하나를 입력해주세요.""");
            int command = sc.nextInt();
            sc.nextLine();


            switch (command) {
                case 1:
                    break;
                case 2:
                    break;
                case 3: // 로그인 메뉴
                    login.ShowMenu();
                    break;
                case 9: // 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다.");
                    continue;
            }
            break;

        }
    }


}
