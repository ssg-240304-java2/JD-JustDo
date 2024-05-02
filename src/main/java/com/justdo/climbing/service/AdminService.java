package com.justdo.climbing.service;

import com.justdo.climbing.dto.member.InstructorDTO;
import com.justdo.climbing.dto.member.MemberDTO;
import com.justdo.climbing.repository.ClimbingRepository;
import com.justdo.climbing.view.ResultPrinter;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminService {

    private ArrayList<MemberDTO> memberList;

    private ResultPrinter resultPrinter = new ResultPrinter();

    private ClimbingRepository repository = ClimbingRepository.getInstance();

    private Scanner sc = new Scanner(System.in);

    private static final String CHECK_PHONE_NUMBER_HYPHEN = "^[\\d]{8}+$";
    private static final int CHECK_PHONE_NUMBER_LENGTH = 8;

    private String USER_ID ="";

    public void inputMember() {
        // 회원리스트가 없으면 생성
        if (memberList == null || memberList.isEmpty()) {
            memberList = new ArrayList<>();
        }


        // 회원정보를 담을 멤버 객체 선언
        MemberDTO m = null;

        System.out.print("(010, - 제외한)휴대폰 번호 8자리를 입력하세요 : ");
        String phone = sc.next();
        boolean instructorPhonNumber =checkInstructorPhonNumber(phone);

        if (!instructorPhonNumber){
            return;
        }

        for (MemberDTO memberDTO : memberList){

            if(phone.equals(memberDTO.getMemberPhone())){
                System.out.println("이미 등록되어있는 핸드폰번호입니다.");
                return;
            }
        }

        // 번호가 8자리가 아니면 메뉴로 다시 돌아감
//        if (phone.length() != 8) {
//            System.out.println("휴대폰번호는 8자리여만 입력해야합니다.");
//            return;
//        } else {
//            // 번호가 8자리이면 입력받은 핸드폰번호를 멤버리스트에서 중복번호가 있는지 검사
//            // 중복된 번호가 있다면 다시 메뉴로 돌아감
//            for (MemberDTO mem : memberList) {
//                if (mem.getMemberPhone().equals(phone)) {
//                    System.out.println("이미 등록되어있는 핸드폰번호입니다.");
//                    return;
//                }
//            }
//        }

        System.out.print("이름을 입력하세요 : ");
        String name = sc.next();

        System.out.println(""" 
                1. 천안
                2. 시흥
                3. 강남점
                4. 양재점
                5. 역삼점
                6. 선릉점
                7. 삼성점""");
        System.out.print("이용하실 지점을 목록에서 선택해주세요. : ");
        int center = sc.nextInt();
        sc.nextLine();

        System.out.print("성별을 입력하세요 남(1), 여(2) : ");
        boolean gender = false;
        int checkGender = sc.nextInt();
        sc.nextLine();
        if (checkGender == 1) {
            gender = true;
        }

        System.out.print("나이를 입력하세요 : ");
        int age = sc.nextInt();
        sc.nextLine();

        // 받은 회원정보를 선언한 멤버객체에 넣어줌
        m = new MemberDTO(name,phone,center,gender,age);

        // 멤버객체를 리스트에 추가
        memberList.add(m);

        resultPrinter.successPage("insertMember");
    }

    public void selectMemberMenu() {
        System.out.println("1. 전체회원조회");
        System.out.println("2. 회원한명조회");

        System.out.print("메뉴 번호 선택 : ");
        int num = sc.nextInt();
        sc.nextLine();
        switch (num) {
            case 1:
                selectAllMember(); // 회원전체조회 메서드실행
                break;

            case 2:
                selectOneMember(inputMemberPhone()); // 회원한명조회 메서드실행
                break;
        }
    }

    /**
     * 핸드폰 번호 입력
     * */
    public String inputMemberPhone() {
        System.out.print("(010, - 제외한)휴대폰 번호 8자리를 입력하세요 : ");
        String phone = sc.next();
        return phone;
    }

    public void selectAllMember() {
        if (memberList == null || memberList.isEmpty()) {
            resultPrinter.errorPage("selectAllMember");
        } else {
            for (MemberDTO m : memberList) {
                System.out.println(m);
            }
        }
    }

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

    public void updateMemberMenu() {
        System.out.println("1. 회원이름수정");
        System.out.println("2. 회원센터수정");
        System.out.println("3. 회원성별수정");
        System.out.println("4. 회원나이수정");
        System.out.println("5. 회원탈퇴");

        System.out.print("메뉴 번호 선택 : ");
        int num = sc.nextInt();
        sc.nextLine();
        switch (num) {
            case 1: // 회원이름변경 메서드 실행
                updateMemberName(inputMemberPhone(), inputMemberName());
                break;
            case 2: // 회원센터변경 메서드 실행
                updateMemberCenter(inputMemberPhone(), inputCenter());
                break;
            case 3: // 회원성별변경 메서드 실행
                updateMemberGender(inputMemberPhone(), inputMemberGender());
                break;
            case 4: // 회원나이변경 메서드 실행
                updateMemberAge(inputMemberPhone(), inputMemberAge());
                break;
            case 5: // 회원탈퇴 메서드 실행
                deleteMember(inputMemberPhone());
                break;
        }
    }

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

    public String inputMemberName() {
        System.out.print("이름을 입력하세요 : ");
        return sc.next();
    }

    public int inputCenter() {
        System.out.println(""" 
                1. 천안
                2. 시흥
                3. 강남점
                4. 양재점
                5. 역삼점
                6. 선릉점
                7. 삼성점""");
        System.out.print("이용하실 지점을 목록에서 선택해주세요. : ");
        int center = sc.nextInt();
        sc.nextLine();
        return center;
    }

    // 회원성별을 입력받는 메서드
    public boolean inputMemberGender() {
        System.out.print("성별을 입력하세요 남(1), 여(2) : ");
        boolean gender = false;
        int checkGender = sc.nextInt();
        sc.nextLine();
        if (checkGender == 1) {
            gender = true;
        }
        return gender;
    }

    // 회원나이를 입력받는 메서드
    public int inputMemberAge() {
        System.out.print("나이를 입력하세요 : ");
        int age = sc.nextInt();
        sc.nextLine();
        return age;
    }

    public void AddInstructorInfo(){
        while (true) {
            System.out.print("핸드폰 번호를 입력해주세요 (010,- 제외 8자리): ");
           // sc.nextLine();
            String inputPhone = sc.nextLine();
            boolean instructorPhonNumber =checkInstructorPhonNumber(inputPhone);
            boolean iscontainsPhoneNumber = repository.isContainsInstructorPhoneNumber(inputPhone);

            if (instructorPhonNumber && !iscontainsPhoneNumber){
                System.out.println("사용 가능한 핸드폰 번호 입니다.");
                //리스트에 추가
                InstructorDTO instructorDTO = new InstructorDTO();
                instructorDTO.setMemberPhone(inputPhone);
                repository.addInstructorDTOList(instructorDTO);
                System.out.println("강사정보 등록이 완료되었습니다.");
                return;
            }

        }
    }

    public boolean checkInstructorPhonNumber(String inputPhoneNumber){

        if(inputPhoneNumber== null || inputPhoneNumber.isBlank()){
            System.out.println("핸드폰번호를 입력해주세요.");
            return false;
        }else if(!inputPhoneNumber.matches(CHECK_PHONE_NUMBER_HYPHEN) || CHECK_PHONE_NUMBER_LENGTH != inputPhoneNumber.length()){
            System.out.println("핸드폰번호를 잘못입력하셨습니다. \n010과 하이픈을 제외한 8자를 입력해주세요.");
            return false;
        } else if (repository.getInstructorListSize() != 0 && repository.isContainsInstructorPhoneNumber(inputPhoneNumber)) {
            // 등록여부확인
            System.out.println("이미 등록되어있는 핸든폰번호입니다. 다시입력해주세요");
            return false;
        } else {
            return true;
        }
    }

    public void EditInstructorInfo(){
        //TODO:등록/수정 flg로 구분하도록 수정
        //TODO:수정할 값에 대한 내용을 선택가능하도록 수정
        //TODO: 이후 전체 수정 및 부분 수정 내용 작성

        while (true){
            System.out.print("핸드폰 번호를 입력해주세요 (010,- 제외 8자리): ");
            String editPhoneNumber = sc.nextLine();
            boolean instructorPhonNumber = checkUpdateInstructorPhonNumber(editPhoneNumber);
            boolean iscontainsPhoneNumber = repository.isContainsUpdateInstructorPhoneNumber(editPhoneNumber);


            if (instructorPhonNumber && iscontainsPhoneNumber){
//                System.out.println(" 핸드폰 번호 입니다.");
                //리스트에 추가
                InstructorDTO instructorDTO = new InstructorDTO();
                instructorDTO.setMemberPhone(editPhoneNumber);
                repository.editInstructorInfo(instructorDTO);
                System.out.println("강사정보 수정이 완료되었습니다.");
                return;
            }
        }

    }

    public boolean checkUpdateInstructorPhonNumber(String inputPhoneNumber){

        if(inputPhoneNumber== null || inputPhoneNumber.isBlank()){
            System.out.println("핸드폰번호를 입력해주세요.");
            return false;
        }else if(!inputPhoneNumber.matches(CHECK_PHONE_NUMBER_HYPHEN) || CHECK_PHONE_NUMBER_LENGTH != inputPhoneNumber.length()){
            System.out.println("핸드폰번호를 잘못입력하셨습니다. \n010과 하이픈을 제외한 8자를 입력해주세요.");
            return false;
        } else if (repository.getInstructorListSize() != 0 && repository.isContainsInstructorPhoneNumber(inputPhoneNumber)) {
            // 등록여부확인
            return true;
        } else {
            return true;
        }
    }

    public void PrintInstructorInfo(){
        if (repository.getInstructorListSize() == 0){
            System.out.println("등록된 강사정보가 없습니다.");
        }else{
            for (InstructorDTO instructorDTO : repository.getInstructorDTOList()){
                System.out.println(instructorDTO.toString());
            }
        }
    }

}
