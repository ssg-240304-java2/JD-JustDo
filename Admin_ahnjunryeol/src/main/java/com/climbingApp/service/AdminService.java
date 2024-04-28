package com.climbingApp.service;

import com.climbingApp.dto.MemberDTO;
import com.climbingApp.service.ResultPrinter;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminService {
    // 회원 리스트 선언
    private ArrayList<MemberDTO> memberList;

    // 결과 출력 객체 생성
    private ResultPrinter rp = new ResultPrinter();

    // 회원정보 입력받는 메서드
    public void inputMember() {
        // 회원리스트가 없으면 생성
        if (memberList == null || memberList.isEmpty()) {
            memberList = new ArrayList<>();
        }

        Scanner sc = new Scanner(System.in);
        // 회원정보를 담을 멤버 객체 선언
        MemberDTO m = null;

        System.out.print("(010, - 제외한)휴대폰 번호 8자리를 입력하세요 : ");
        String phone = sc.next();

        // 번호가 8자리가 아니면 메뉴로 다시 돌아감
        if (phone.length() != 8) {
            System.out.println("휴대폰번호는 8자리여만 입력해야합니다.");
            return;
        } else {
            // 번호가 8자리이면 입력받은 핸드폰번호를 멤버리스트에서 중복번호가 있는지 검사
            // 중복된 번호가 있다면 다시 메뉴로 돌아감
            for (MemberDTO mem : memberList) {
                if (mem.getMemberPhone().equals(phone)) {
                    System.out.println("이미 등록되어있는 핸드폰번호입니다.");
                    return;
                }
            }
        }

        System.out.print("이름을 입력하세요 : ");
        String name = sc.next();

        System.out.print("사용지점을 입력하세요(강남 (1), 역삼 (2), 방배 (3) : ");
        int center = sc.nextInt();

        System.out.print("성별을 입력하세요 남(1), 여(2) : ");
        boolean gender = false;
        int checkGender = sc.nextInt();

        if (checkGender == 1) {
            gender = true;
        }

        System.out.print("나이를 입력하세요 : ");
        int age = sc.nextInt();

        // 받은 회원정보를 선언한 멤버객체에 넣어줌
        m = new MemberDTO(phone, name, center, gender, age);

        // 멤버객체를 리스트에 추가
        memberList.add(m);

        rp.successPage("insertMember");
    }

    // 회원 전체 조회 메소드
    public void selectAllMember() {
        if (memberList == null || memberList.isEmpty()) {
            rp.errorPage("selectAllMember");
        } else {
            for (MemberDTO m : memberList) {
                System.out.println(m);
            }
        }
    }

    // 핸드폰번호 입력받는 메서드
    public String inputMemberPhone() {
        Scanner sc = new Scanner(System.in);
        System.out.print("(010, - 제외한)휴대폰 번호 8자리를 입력하세요 : ");
        String phone = sc.next();

        return phone;
    }

    // 회원 한명 조회
    public void selectOneMember(String memberPhone) {
        if (memberList != null) {
            for (int i = 0; i < memberList.size(); i++) {
                if (memberList.get(i).getMemberPhone().equals(memberPhone)) {
                    System.out.println(memberList.get(i));
                    break;
                }
            }
        }
    }

    // 회원이름을 입력받는 메서드
    public String inputMemberName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요 : ");
        return sc.next();
    }

    // 회원센터를 입력받는 메서드
    public int inputCenter() {
        Scanner sc = new Scanner(System.in);
        System.out.print("사용지점을 입력하세요(강남 (1), 역삼 (2), 방배 (3) : ");
        return sc.nextInt();
    }

    // 회원성별을 입력받는 메서드
    public boolean inputMemberGender() {
        Scanner sc = new Scanner(System.in);
        System.out.print("성별을 입력하세요 남(1), 여(2) : ");
        boolean gender = false;
        int checkGender = sc.nextInt();

        if (checkGender == 1) {
            gender = true;
        }
        return gender;
    }

    // 회원나이를 입력받는 메서드
    public int inputMemberAge() {
        Scanner sc = new Scanner(System.in);
        System.out.print("나이를 입력하세요 : ");
        return sc.nextInt();
    }


    // 회원 정보 수정 메서드
    // 회원 나이 수정
    public void updateMemberName(String memberPhone, String memberName) {
        if (memberList != null) {
            // 핸드폰번호와 일치하는 회원 탐색
            for (int i = 0; i < memberList.size(); i++) {
                // 일치하는 회원이 있을경우 이름수정
                if (memberList.get(i).getMemberPhone().equals(memberPhone)) {
                    memberList.get(i).setMemberName(memberName);
                    break;
                }
            }
        }
    }

    // 회원 센터 수정
    public void updateMemberCenter(String memberPhone, int center) {
        if (memberList != null) {
            // 핸드폰번호와 일치하는 회원 탐색
            // 일치하는 회원이 있을경우 센터수정
            for (int i = 0; i < memberList.size(); i++) {
                if (memberList.get(i).getMemberPhone().equals(memberPhone)) {
                    memberList.get(i).setCenter(center);
                    break;
                }
            }
        }
    }

    // 회원 성별 수정
    public void updateMemberGender(String memberPhone, boolean memberGender) {
        if (memberList != null) {
            // 핸드폰번호와 일치하는 회원 탐색
            for (int i = 0; i < memberList.size(); i++) {
                // 일치하는 회원이 있을경우 성별수정
                if (memberList.get(i).getMemberPhone().equals(memberPhone)) {
                    memberList.get(i).setMemberGender(memberGender);
                    break;
                }
            }
        }
    }

    // 회원 나이 수정
    public void updateMemberAge(String memberPhone, int memberAge) {
        if (memberList != null) {
            // 핸드폰번호와 일치하는 회원 탐색
            for (int i = 0; i < memberList.size(); i++) {
                // 일치하는 회원이 있을경우 나이수정
                if (memberList.get(i).getMemberPhone().equals(memberPhone)) {
                    memberList.get(i).setMemberAge(memberAge);
                    break;
                }
            }
        }
    }

    // 회원 정보 삭제
    public void deleteMember(String memberPhone) {
        // 입력한 핸드폰번호를 갖고있는 회원정보를 담을 변수 선언
        MemberDTO m = null;
        if (memberList != null) {
            // 핸드폰번호와 일치하는 회원 탐색
            for (int i = 0; i < memberList.size(); i++) {
                // 일치하는 회원이 있을경우 회원의 정보를 담고 해당하는 회원삭제
                if (memberList.get(i).getMemberPhone().equals(memberPhone)) {
                    m = memberList.get(i);
                    memberList.remove(m);
                }
            }
        }
    }

}