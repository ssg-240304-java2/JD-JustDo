package climbingApplication;

import java.util.Scanner;

public class Controller {
    Repository repository = new Repository();
    private String[] loginInformation = null ;
    private final String adminId = "admin";
    private final String adminSecrete = "admin";

    // 강사 번호
    private int instructorNo = 0;

    public int getInstructorNo() {
        return instructorNo;
    }

    public void setInstructorNo(int instructorNo) {
        this.instructorNo = instructorNo;
    }

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
                isTrue = instructorLogin(loginInformation);
            }else{
                // 회원 로그인 메소드 호출
            }
        }
        return true;
    }
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
    public boolean instructorLogin(String[] arr){
        boolean result = false;

        for (int i = 0; i < repository.instructorDTOList.size(); i++) {
            if (arr[0].equals(repository.instructorDTOList.get(i).getMemberPhone())) {
                if (arr[1].equals(repository.instructorDTOList.get(i).getMemberPhone())) {
                    setInstructorNo(repository.instructorDTOList.get(i).getInstructorNo());
                    result = false;
                    break;
                } else {
                    System.out.println("비밀번호 오류");
                    result = true;
                }
            } else {
                System.out.println("로그인 오류");
                result = true;
            }
        }
        return result;
    }
    public boolean clientLogin(String[] arr){
        return false;
    }
}
