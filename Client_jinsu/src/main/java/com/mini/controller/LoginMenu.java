package com.mini.controller;

import com.mini.enumcode.AuthorityCode;
import com.mini.model.dto.member.ClientDTO;
import com.mini.service.AddMember;
import com.mini.service.IdentifyMember;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginMenu {
    Scanner sc = new Scanner(System.in);
    ClientMenu_login info = new ClientMenu_login();
    ArrayList<ClientDTO> clientDTOList = new ArrayList<>();
    ResultPrinter resultPrinter = new ResultPrinter();
    ClientDTO loggedMember;


    public void ShowMenu() {
        clientDTOList.add(new ClientDTO("박진수", "11111111", 1, false, 29, 1, 1 ));
        clientDTOList.add(new ClientDTO("안준렬", "22222222", 2, false, 29, 2, 2));
        clientDTOList.add(new ClientDTO("이은솔", "33333333", 3, true, 29, 3, 3));
        clientDTOList.add(new ClientDTO("장준영", "44444444", 3, false, 29, 4, 4));
        clientDTOList.add(new ClientDTO("이정훈", "55555555", 1, false, 29, 5, 5));

        while (true) {
            System.out.print("""
                    =========================================
                    ==로그인 및 내 정보 조회를 원하시면 1번==
                    =======회원가입을 원하시면 2번   ========
                    뒤로가기를 원하시면 9번을 입력해주세요.
                    ========================================
                    숫자를 입력해주세요 :
                    """);
            int command = sc.nextInt();
            sc.nextLine();

            switch (command) {
                case 1:
                    resultPrinter.showResult(1, clientDTOList, loggedMember); // 지점 출력
                    while (true) {
                        loggedMember = IdentifyMember.isIdentified(clientDTOList);
                        if (loggedMember != null) {
                            resultPrinter.showResult(2, clientDTOList, loggedMember); //로그인 완료 표시
                            info.showInfo(loggedMember); // InfoMenu에 회원 정보 전달
                            break;
                        } else {
                            resultPrinter.showResult(4, clientDTOList, loggedMember); //정보 다시 입력
                            break;
                        }
                    }
                    break;
                case 2:
                    AddMember.addId(clientDTOList);
                    break;
                case 9:
                    System.out.println("이전 화면으로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
            System.out.println();
        }
    }
}
