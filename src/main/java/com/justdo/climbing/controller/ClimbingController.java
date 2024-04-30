package com.justdo.climbing.controller;

import com.justdo.climbing.dto.member.ClientDTO;
import com.justdo.climbing.service.AdminService;
import com.justdo.climbing.service.ClientService;
import com.justdo.climbing.service.InstructorService;

import java.util.Scanner;

public class ClimbingController {

    private final String adminId = "admin";
    private final String adminSecrete = "admin";

    private Scanner sc = new Scanner(System.in);

    private InstructorService instructorService = new InstructorService();
    private ClientService clientService = new ClientService();


    /**
     * 선택한 메뉴 번호 확인
     * */
    public int selectMenuNum(){
        // TODO : Scanner를 Controller에 작성한 이유? view에 넣고 파라미터로 받아도 되는지?
//        Scanner sc = new Scanner(System.in);
        int num;
        while(true){
            try{
                System.out.print("번호를 입력해주세요 : ");
                num = sc.nextInt();

                // TODO:try-catch사용하는데 비교할 필요 있는지?
                if(Integer.class.isInstance(num)){
                    sc.nextLine();
                    return num;
                }
            } catch (Exception e){
                System.out.println("메뉴의 정수만 입력하세요.");
                sc.nextLine();
            }
        }
    }

    /**
     * 권한이 일치한 경우 로그인 진행
     * 배열 -> 각가 받는것으로 변경
     * */
    public boolean logIn(String authority){
        boolean isTrue = true;
//        Scanner sc = new Scanner(System.in);
        while(isTrue) {

            System.out.print("아이디(핸드폰 번호)를 입력하시오 : ");
            String id = sc.nextLine();
            System.out.print("비밀번호를 입력하시오 : ");
            String secreteNum = sc.nextLine();
//            this.loginInformation = new String[]{id, secreteNum};
            if ("관리자".equals(authority)) {
                isTrue = adminLogIn(id,secreteNum);
            }else if ("강사".equals(authority)){
                // 강사 로그인 메소드 호출
                isTrue = instructorLogin(id,secreteNum);
            }else{
                // 회원 로그인 메소드 호출
                //TODO:로그인과 회원 정보 출력 분리 필요
                ClientDTO clientDTO = clientService.ClientLogin();
                isTrue = (clientDTO != null);
                System.out.println(clientDTO.toString());
            }
        }
        return true;
    }

    /**
     * Controller 안에서만 실행될것이기 때문에 private으로 변경
     * 배열 -> id,pwd
     * */
    private boolean adminLogIn(String id, String secrete){
        if(adminId.equals(id)){
            if(adminSecrete.equals(secrete)){
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

    public boolean instructorLogin(String id, String secrete){

        // service에서 로그인 처리 이동
        return instructorService.instructorLogin(id,secrete);

    }

}
