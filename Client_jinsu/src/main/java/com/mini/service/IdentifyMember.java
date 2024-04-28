package com.mini.service;

import com.mini.model.dto.member.ClientDTO;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IdentifyMember {
    static Scanner sc = new Scanner(System.in);

    public static ClientDTO isIdentified(ArrayList<ClientDTO> clientDTOList) { // 회원 가입 전 기존 회원인지 확인
        ClientDTO identifiedMember = null;

        while (identifiedMember == null) {
            try {
                sc = new Scanner(System.in);
                System.out.print("핸드폰번호를 입력해주세요(010, ' - ' 제외 8자리 : ");
                String phoneNum = sc.nextLine();
                if (phoneNum.length() != 8) {
                    throw new IllegalArgumentException("허용되지 않은 번호입니다. 010, ' - ' 제외 숫자 8자리 입력해주세요");
                }
                System.out.print("지점 번호를 입력해주세요 : ");
                int center = sc.nextInt();
                sc.nextLine();
                if (center < 0) {
                    throw new IllegalArgumentException("지점 번호는 음수일 수 없습니다.");
                }

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
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력 형식입니다. 다시 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return identifiedMember;
    }
}
