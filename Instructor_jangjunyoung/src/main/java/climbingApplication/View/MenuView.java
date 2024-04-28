package climbingApplication.View;

import climbingApplication.DTO.Member.ClientDTO;
import climbingApplication.DTO.Member.InstructorDTO;
import climbingApplication.ENUM.AuthorityCode;
import climbingApplication.Controller;
import climbingApplication.Repository;

import java.util.Scanner;

public class MenuView {
    private InstructorDTO instructorDTO;
    private ClientDTO clientDTO;
    AuthorityCode authorityCode;
    private Controller controller = new Controller();
    Repository repository = new Repository();

    public void AuthorityMenu(){
        Scanner sc = new Scanner(System.in);
        boolean isTrue = true;
        while(isTrue) {
            System.out.println("""
                =================================
                안녕하세요.
                신세계 클라이밍 센터입니다.
                사용자 정보를 선택해 주세요.
                1. 관리자
                2. 강사
                3. 고객
                9. 종료
                ==================================
                """);
            int authority;
            try{
                System.out.print("번호를 입력해주세요 : ");
                authority = sc.nextInt();
            }catch(Exception e){
                System.out.println("메뉴의 정수만 입력하세요.");
                continue;
            }
            sc.nextLine();
            switch (authority) {
                case 1:
                    authorityCode = AuthorityCode.ADMIN;
                    System.out.println(authorityCode.getDescription() + " 을(를) 선택했습니다.");
                    AdminMenu();
                    break;
                case 2:
                    authorityCode = AuthorityCode.INSTRUCTOR;
                    System.out.println(authorityCode.getDescription() + " 을(를) 선택했습니다.");
                    InstructorMenu();
                    break;
                case 3:
                    authorityCode = AuthorityCode.CLIENT;
                    System.out.println(authorityCode.getDescription() + " 을(를) 선택했습니다.");
                    ClientMenu();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    isTrue = false;
                    break;
                default:
                    System.out.println("잘못된 숫자를 입력했습니다. 다시 입력해 주세요");
                    break;
            }
        }

    }

    public void InstructorMenu(){
        Scanner sc = new Scanner(System.in);
        while(true){
            // 로그인 미진행 시 아래 화면
            System.out.println("""
                    =========================================
                    강사전용 도메인 입니다.
                    메뉴를 선택해 주세요.
                    1. 로그인
                    9. 뒤로가기
                    =========================================
                    """);
            int num;
            try{
                System.out.print("번호를 입력해주세요 : ");
                num = sc.nextInt();
            }catch(Exception e){
                System.out.println("메뉴의 정수만 입력하세요.");
                continue;
            }
            sc.nextLine();
            switch (num){
                case 1:
                    // 로그인 완료시 아래 메소드 호출
                    if (controller.logIn(authorityCode.getDescription())) {
                        InstructorMenu_login();
                    }
                    break;
                case 9:
                    // 로그인을 안했으면
                    System.out.println("이전화면으로 되돌아갑니다.");
                    return;
                    // 로그인을 완료했으면 객체 반환 및 break;
                    // instructorDTO = new InstructorDTO(); 객체 초기화
                default:
                    System.out.println("잘못된 숫자를 입력했습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }

    public void InstructorMenu_login(){
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("""
                    =========================================
                    강사전용 도메인 입니다.
                    메뉴를 선택해 주세요.
                    1. 내 정보
                    2. 회원 조회
                    9. 로그아웃
                    =========================================
                    """);
            int num;
            try{
                System.out.print("번호를 입력해주세요 : ");
                num = sc.nextInt();
            }catch(Exception e){
                System.out.println("메뉴의 정수만 입력하세요.");
                continue;
            }
            sc.nextLine();
            switch (num){
                case 1:
                    // 로그인 완료 후 내 정보 불러오기
                    for (int i = 0; i < repository.getInstructorDTOList().size(); i++) {
                        if (controller.getInstructorNo() == repository.getInstructorDTOList().get(i).getInstructorNo()) {
                            System.out.println("=====================================");
                            System.out.println("강사 이름: " + repository.getInstructorDTOList().get(i).getMemberName());
                            System.out.println("강사 전화번호: " + repository.getInstructorDTOList().get(i).getMemberPhone());
                            System.out.println("강사 지점: " + repository.getInstructorDTOList().get(i).getCenter());
                            System.out.println("강사 성별: " + repository.getInstructorDTOList().get(i).isMemberGender());
                            System.out.println("강사 나이: " + repository.getInstructorDTOList().get(i).getMemberAge());
                            System.out.println("강사 번호: " + repository.getInstructorDTOList().get(i).getInstructorNo());
                            System.out.println("강사 등급: " + repository.getInstructorDTOList().get(i).getInstructorGrade());
                            System.out.println("=====================================");
                        }
                    }
                    break;
                case 2:
                    // 레퍼지토리에서 내 회원 리스트 메소드 불러오기
                    for (int i = 0; i < repository.getClientDTOList().size(); i++) {
                        if (controller.getInstructorNo() == repository.getClientDTOList().get(i).getInstructorNo()) {
                            System.out.println("=====================================");
                            System.out.println("회원 이름: " + repository.getClientDTOList().get(i).getMemberName());
                            System.out.println("회원 전화번호: " + repository.getClientDTOList().get(i).getMemberPhone());
                            System.out.println("회원 지점: " + repository.getClientDTOList().get(i).getCenter());
                            System.out.println("회원 성별: " + repository.getClientDTOList().get(i).isMemberGender());
                            System.out.println("회원 나이: " + repository.getClientDTOList().get(i).getMemberAge());
                            System.out.println("이용 기간: " + repository.getClientDTOList().get(i).getDuration());
                            System.out.println("지정 강사번호: " + repository.getClientDTOList().get(i).getInstructorNo());
                            System.out.println("=====================================");
                        }
                    }

                    break;
                case 9:
                    System.out.println("로그아웃을 완료했습니다.");
                    return;
                default:
                    System.out.println("잘못된 숫자를 입력했습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }

    public void ClientMenu(){
        Scanner sc = new Scanner(System.in);
        while(true){
            // 회원 객체가 null이면 => 로그인을 아직 안했으면 (조건절)
            System.out.println("""
                    =========================================
                    회원전용 도메인 입니다.
                    메뉴를 선택해 주세요.
                    1. 회원가입
                    2. 로그인
                    9. 뒤로가기
                    =========================================
                    """);
            int num;
            try{
                System.out.print("번호를 입력해주세요 : ");
                num = sc.nextInt();
            }catch(Exception e){
                System.out.println("메뉴의 정수만 입력하세요.");
                continue;
            }
            sc.nextLine();
            switch (num){
                case 1:
                    // 회원가입 메소드 호출
                    break;
                case 2:
                    // 로그인 메소드 호출
                    ClientMenu_login();
                    break;
                case 9:
                    System.out.println("이전화면으로 되돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못된 숫자를 입력했습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }

    public void ClientMenu_login(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("""
                    =========================================
                    고객전용 도메인 입니다.
                    메뉴를 선택해 주세요.
                    1. 내정보
                    2. 회원권 구매
                    3. 물품 구매
                    9. 로그아웃
                    =========================================
                    """);
            int num;
            try{
                System.out.print("번호를 입력해주세요 : ");
                num = sc.nextInt();
            }catch(Exception e){
                System.out.println("메뉴의 정수만 입력하세요.");
                continue;
            }
            sc.nextLine();
            switch (num){
                case 1:
                    // 내정보 불러오기 메소드
                    break;
                case 2:
                    // 회원권 구매 메소드
                    break;
                case 3:
                    // 물품 구매 메소드
                    break;
                case 9:
                    System.out.println("로그아웃을 완료했습니다.");
                    return;
                default:
                    System.out.println("잘못된 숫자를 입력했습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }

    public void AdminMenu(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("""
                    =========================================
                    관리자 메뉴입니다.
                    1. 로그인
                    9. 뒤로가기
                    =========================================
                    """);
            int num;
            try{
                System.out.print("번호를 입력해주세요 : ");
                num = sc.nextInt();
            }catch(Exception e){
                System.out.println("메뉴의 정수만 입력하세요.");
                continue;
            }
            sc.nextLine();
            switch (num){
                case 1:
                    // 로그인 메소드 호출
                    // 완료후 로그인후 페이지 호출
                    if(controller.logIn(authorityCode.getDescription())) {
                        AdminMenu_login();
                    }
                    break;
                case 9:
                    System.out.println("이전화면으로 되돌아갑니다.");
                    return;
            }
        }
    }

    public void AdminMenu_login(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("""
                        =========================================
                        관리자 전용 도메인 입니다.
                        메뉴를 선택해 주세요.
                        1. 회원 등록
                        2. 강사 등록
                        3. 회원 정보 수정
                        4. 강사 정보 수정
                        5. 물품 관리
                        9. 로그아웃
                        =========================================
                    """);
            int num;
            try{
                System.out.print("번호를 입력해주세요 : ");
                num = sc.nextInt();
            }catch(Exception e){
                System.out.println("메뉴의 정수만 입력하세요.");
                continue;
            }
            sc.nextLine();
            switch (num){
                case 1:
                    // 회원등록 메소드 호출
                    break;
                case 2:
                    // 강사 등록 메소드 호출
                    break;
                case 3:
                    // 회원 정보 수정 메소드 호출
                    break;
                case 4:
                    // 강사 정보 수정 메소드 호출
                    break;
                case 5:
                    // 물품관리 메소드 호출
                    break;
                case 9:
                    System.out.println("로그아웃을 완료했습니다.");
                    return;
                default:
                    System.out.println("잘못된 숫자를 입력했습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }
}
