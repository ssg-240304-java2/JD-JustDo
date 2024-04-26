package com.mini.controller;

import com.mini.enumcode.AuthorityCode;
import com.mini.model.dto.member.ClientDTO;
import java.util.ArrayList;

public class ResultPrinter {

    public void showResult(int msg, ArrayList<ClientDTO> clientDTOList, ClientDTO loggedMember) {

        switch (msg) {
            case 1: // 전체 지점 출력
                for (ClientDTO client : clientDTOList) {
                    System.out.print(client.getCenter() + " ");
                }
                System.out.println();
                break;
            case 2: // 로그인 완료 출력
                System.out.println("로그인 완료되었습니다.");
                break;
            case 3: // 에러 출력
                System.out.println("이미 등록되어있는 핸드폰 번호입니다.");
                break;
            case 4: // 에러 출력
                System.out.println("정보를 다시 입력해주세요.");
                break;
            case 5: // 내 정보 입력
                if (loggedMember != null) {
                    System.out.println("회원 이름: " + loggedMember.getMemberName());
                    System.out.println("회원 전화번호: " + loggedMember.getMemberPhone());
                    System.out.println("회원 지점: " + loggedMember.getCenter());
                    System.out.println("회원 성별: " + loggedMember.isMemberGender());
                    System.out.println("회원 나이: " + loggedMember.getMemberAge());
                    System.out.println("이용 기간: " + loggedMember.getDuration());
                    System.out.println("지정 강사번호: " + loggedMember.getInstructorNo());
                } else {
                    System.out.println("로그인한 회원의 정보가 없습니다.");
                }
                break;
            case 6: // 회원등록 완료
                System.out.println("회원 등록이 완료되었습니다.");
                break;
            case 7: // 로그아웃
                System.out.println("로그아웃이 완료되었습니다. 이전으로 돌아갑니다.");
                break;
        }
    }
}
