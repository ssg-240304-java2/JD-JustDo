package com.mini.controller;


import com.mini.model.dto.member.ClientDTO;
import com.mini.service.PurchaseMemberShip;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientMenu_login {
    public Scanner sc = new Scanner(System.in);
    ResultPrinter resultPrinter = new ResultPrinter();
    ArrayList<ClientDTO> clientDTOList = new ArrayList<>();

    public void showInfo(ClientDTO loggedMember) {
        while (true) {
            System.out.print("""
                    ========================================
                    1. 내 정보 표시
                    2. 센터 이용권 구매
                    3. 로그아웃 및 뒤로가기
                    ========================================
                    숫자를 입력해주세요 :
                    """);
            int command = sc.nextInt();
            sc.nextLine();

            switch (command) {
                case 1: //내 정보 출력
                    resultPrinter.showResult(5, clientDTOList, loggedMember);
                    break;
                case 2: //센터 이용권 구매
                    PurchaseMemberShip.purchase(loggedMember);
                    break;
                case 3: // 로그아웃
                    resultPrinter.showResult(7, clientDTOList, loggedMember);
                    return;

            }
        }
    }
}