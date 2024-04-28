package climbingApplication;

import java.util.Scanner;

public class Controller {
    Repository repository = new Repository();
    private String[] loginInformation = null ;
    private final String adminId = "admin";
    private final String adminSecrete = "admin";

    // 숫자 선택 메소드 (메뉴에서 메뉴 선택 메소드)
    public int selectNum(){
        Scanner sc = new Scanner(System.in);
        int num;
        while(true){
            try{
                System.out.print("번호를 입력해주세요 : ");
                num = sc.nextInt();
                if(Integer.class.isInstance(num)){
                    return num;
                }
            } catch (Exception e){
                System.out.println("메뉴의 정수만 입력하세요.");
                sc.nextLine();
            }
        }
    }
    // 로그인 입력 메소드 (권한을 부여받아 로그인 입력 메소드)
    public boolean logIn(String authority){
        boolean isTrue = true;
        while(isTrue) {
            Scanner sc = new Scanner(System.in);
            System.out.print("아이디(핸드폰 번호)를 입력하시오 : ");
            String id = sc.nextLine();
            System.out.print("비밀번호를 입력하시오 : ");
            String secreteNum = sc.nextLine();
            this.loginInformation = new String[]{id, secreteNum};
            if (authority.equals("관리자")) {
                isTrue = adminLogIn(loginInformation);
            }else if (authority.equals("강사")){
                // 강사 로그인 메소드 호출
            }else{
                // 회원 로그인 메소드 호출
            }
        }
        return true;
    }

    // 관리자 로그인 메소드 (관리자의 로그인 입력 메소드)
    public boolean adminLogIn(String[] arr){
        if(arr[0].equals(adminId)){
            if(arr[1].equals(adminSecrete)){
                return false;
            }else{
                System.out.println("비밀번호 오류");
                return true;
            }
        }else{
            System.out.println("로그인 오류");
            return true;
        }
    }

    // 강사 로그인 메소드
    public boolean instructorLogin(String[] arr){
        return false;
    }

    // 고객 로그인 메소드
    public boolean clientLogin(String[] arr){
        return false;
    }
}
