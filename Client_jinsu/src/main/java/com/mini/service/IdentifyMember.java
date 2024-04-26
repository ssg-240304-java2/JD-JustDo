package com.mini.service;

import com.mini.model.dto.member.ClientDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class IdentifyMember {
    static Scanner sc = new Scanner(System.in);

    public static ClientDTO isIdentified(ArrayList<ClientDTO> clientDTOList) {
        ClientDTO identifiedMember = null;

        while (identifiedMember == null) {
            sc = new Scanner(System.in);
            System.out.print("핸드폰번호를 입력해주세요(010, ' - ' 제외 8자리 : ");
            String phoneNum = sc.nextLine();
            System.out.print("지점 번호를 입력해주세요 : ");
            int center = sc.nextInt();
            sc.nextLine();

            // 입력받은 핸드폰 번호와 기존 번호를 기존의 list와 비교
            if (clientDTOList != null && !clientDTOList.isEmpty()) {
                for (ClientDTO c : clientDTOList) {
                    if (c.getMemberPhone().equals(phoneNum) && c.getCenter() == center) {
                        identifiedMember = c;
                        break;
                    }
                }
            }
            if (identifiedMember == null) {
                System.out.println("유효한 회원이 아닙니다. 다시 입력해주세요");
            }
        }
        return identifiedMember;
    }
}
