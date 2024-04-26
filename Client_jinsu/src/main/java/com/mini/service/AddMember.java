package com.mini.service;

import com.mini.controller.ResultPrinter;
import com.mini.model.dto.member.ClientDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class AddMember {
    static ResultPrinter resultPrinter = new ResultPrinter();
    static Scanner sc = new Scanner(System.in);
    static ArrayList<ClientDTO> clientDTOList;
    static ClientDTO loggedMember;


    public static void addId(ArrayList<ClientDTO> clientDTOList){
        while (true) {
            System.out.println("""
                    ========================================
                    회원 가입 메뉴입니다.
                    핸드폰번호를 입력해주세요
                    (010, ' - ' 제외 8자리)
                    뒤로 가기를 원하시면 ' 9 '를 눌러주세요
                    ========================================
                        숫자를 입력해주세요 :
                    """);
            String phoneNum = sc.nextLine();

            if (Integer.parseInt(phoneNum) == 9){
                return;
            }

            if (clientDTOList != null && !clientDTOList.isEmpty()) {
                for (ClientDTO c : clientDTOList) {
                    if (c.getMemberPhone().equals(phoneNum)) {
                        resultPrinter.showResult(3, clientDTOList, loggedMember);
                        return;
                    } else {
                        System.out.println("이름을 입력해주세요");
                        String name = sc.nextLine();
                        System.out.println("사용지점을 입력해주세요 (int)");
                        int center = sc.nextInt();
                        sc.nextLine();
                        System.out.println("성별을 입력해주세요 (true/false)");
                        boolean gender = sc.nextBoolean();
                        System.out.println("나이를 입력해주세요");
                        int age = sc.nextInt();

                        ClientDTO newMember = new ClientDTO(name, phoneNum, center, gender, age, 0, 0);
                        clientDTOList.add(newMember);
                        resultPrinter.showResult(6, clientDTOList, loggedMember);
                        return;
                    }
                }
            }
            break;
        }
    }
}
