package com.justdo.climbing.controller;

import com.justdo.climbing.model.constant.AuthorityCode;
import com.justdo.climbing.model.dto.member.ClientDTO;
import com.justdo.climbing.model.service.ClientSerivce;
import com.justdo.climbing.model.service.InstructorService;
import com.justdo.climbing.model.service.common.CommonService;
import com.justdo.climbing.view.MenuView;

import java.util.List;

public class ClimbingController {

    private MenuView menuView = new MenuView();
    private InputReader inputReader = InputReaderFactory.getInputReader();
    private CommonService commonService = new CommonService();
    private ClientSerivce clientSerivce = new ClientSerivce();
    private InstructorService instructorService = new InstructorService();

    public void authorityMenu()  {
        while (true){

            // 권한 메뉴 표시
            menuView.authorityMenuView();

            // 메뉴 입력
            int authNum = inputReader.selectMenuNum();

            //입력한 메뉴별 처리
            switch (authNum) {
                case 1:
                    System.out.println(AuthorityCode.ADMIN.getDescription()+ "권한 을(를) 선택했습니다.");
                    adminMenu(AuthorityCode.ADMIN.name());

                    break;
                case 2:
                    System.out.println(AuthorityCode.INSTRUCTOR.getDescription() + " 을(를) 선택했습니다.");
                    instructorMenu(AuthorityCode.INSTRUCTOR.name());
                    break;
                case 3:
                    System.out.println(AuthorityCode.CLIENT.getDescription() + " 을(를) 선택했습니다.");
                    clientMenu(AuthorityCode.CLIENT.name());
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    InputReaderFactory.getInputReader().close();
                    return;
                default:
                    System.out.println("선택하신 권한은 없는 권한입니다. \n 다시 입력해 주세요");
                    break;
            }
        }
    }

    public void adminMenu(String authName){

        while (true){
            // 로그인전 관리자 메뉴 표시
            menuView.mainMenuView();
            //메뉴입력
            int menuNum = inputReader.selectMenuNum();

            // id password 초기화
            String id ="";
            String password = "";

            //입력한 메뉴별 처리
            switch (menuNum){
                case 1:// 로그인

                    System.out.print("아이디를 입력해주세요 : ");
                    id = inputReader.inputString();

                    System.out.print("비밀번호를 입력해주세요 : ");
                    password = inputReader.inputString();

                    //로그인 진행
                    boolean isLogin = commonService.login(authName, id, password) != null;
                    if(isLogin){
                        //로그인후 관리자 화면
                        adminLoginMenu();
                    }

                    break;
                case 9:
                    System.out.println("이전화면으로 되돌아갑니다.");
                    return;
            }
        }

    }

    public void adminLoginMenu(){
        while (true){
            menuView.adminLoginMenuView();

            //메뉴입력
            int menuNum = inputReader.selectMenuNum();

            switch (menuNum){
                case 1:
                    // 회원정보 등록
                    clientSerivce.addClientInfo();
                    break;
                case 2:
                    // 강사 등록 메소드 호출
                    instructorService.addInstructorInfo();
                    break;
                case 3:
                    // 회원 정보 수정 메소드 호출
                    clientUpdateInfoMenu();
                    break;
                case 4:
                    // 강사 정보 수정 메소드 호출
                    instructorUpdateInfoMenu();
                    break;
                case 5:
    //                // 회원 정보 조회 메소드 호출
                    adminSearchInfo(AuthorityCode.CLIENT.name());
                    break;
                case 6:
                    adminSearchInfo(AuthorityCode.INSTRUCTOR.name());
                    break;
                case 7:
                    // 물품관리 메소드 호출
                    break;
                case 9:
                    System.out.println("로그아웃을 완료했습니다.");
                    return;
                default:
                    System.out.println("잘못된 숫자를 입력했습니다.\n다시 입력해주세요.");
                    break;
            }
        }
    }

    public void adminSearchInfo(String auth){
        while (true){
            menuView.searchMenuView();
            System.out.print("메뉴를 입력하세요:");
            int menuNum = inputReader.selectMenuNum();
            switch (menuNum){
                case 1:
                    if("CLIENT".equals(auth)){
                        clientSerivce.printClientListInfo(null);
                    }else {
                        instructorService.printInstructorInfo(null);
                    }
                    break;
                case 2:
                    System.out.print("조회하실 핸드폰 번호를 입력하세요 : ");
                    String phoneNum = inputReader.inputString();
                    if("CLIENT".equals(auth)){
                        clientSerivce.printClientListInfo(phoneNum);
                    }else {
                        instructorService.printInstructorInfo(phoneNum);
                    }
                    break;
                case 9:
                    return;
                default:
                    System.out.println("메뉴를 다시 입력해주세요.");
                    break;
            }
        }

    }



    public void clientUpdateInfoMenu(){
        while (true){
            menuView.updateClientMenu();
            int updateMenuNum = inputReader.selectMenuNum();
            switch (updateMenuNum){
                case 1:
                case 2:
                case 3:
                case 4:
                    clientSerivce.updateClientInfo(updateMenuNum);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 숫자를 입력했습니다.\n다시 입력해주세요.");
                    break;

            }
        }
    }

    public void clientMenu(String authName){
        String id = "";
        String password = "";
        while (true){
            menuView.clientMenuView();
            int menuNum = inputReader.selectMenuNum();
            switch (menuNum){
                case 1:
                    // 회원가입 메소드 호출
                    clientSerivce.addClientInfo();
                    break;
                case 2:
                    // 로그인 메소드 호출
                    System.out.print("핸드폰번호를 입력해주세요 : ");
                    id = inputReader.inputString();

                    System.out.print("이름을 입력해주세요 : ");
                    password = inputReader.inputString();

                    //로그인 진행
                    boolean isLogin = commonService.login(authName, id, password) != null;
                    if(isLogin){
                        //로그인후 관리자 화면
                        clientLoginMenu(id);
                    }
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

    public void clientLoginMenu(String id){
        while (true){
            menuView.clientLoginMenuView();
            int menuNum = inputReader.selectMenuNum();
            switch (menuNum){
                case 1:
                    // 내정보 불러오기 메소드
                    clientSerivce.printClientListInfo(id);
                    break;
                case 2:
                    // 회원권 구매 메소드
                    System.out.println("구현 예정입니다.");
//                    clientService.purchase(id);
                    break;
                case 3:
                    // 물품 구매 메소드
                    System.out.println("구현 예정입니다.");
                    break;
                case 4:
                    // 입장하기 메소드 호출
                    System.out.println("구현 예정입니다.");
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

    public void instructorMenu(String authName){

        while (true){
            // 로그인전 관리자 메뉴 표시
            menuView.mainMenuView();
            //메뉴입력
            int menuNum = inputReader.selectMenuNum();

            // id password 초기화
            String id ="";
            String password = "";

            //입력한 메뉴별 처리
            switch (menuNum){
                case 1:// 로그인

                    System.out.print("핸드폰번호를 입력해주세요 : ");
                    id = inputReader.inputString();

                    System.out.print("이름을 입력해주세요 : ");
                    password = inputReader.inputString();

                    //로그인 진행
                    boolean isLogin = commonService.login(authName, id, password) != null;
                    if(isLogin){
                        instructorLoginMenu(id);
                    }
                    break;
                case 9:
                    System.out.println("이전화면으로 되돌아갑니다.");
                    return;
            }
        }
    }

    public void instructorLoginMenu(String id){
        while (true){
            menuView.instructorLoginMenuView();
            int menuNum = inputReader.selectMenuNum();
            switch (menuNum){
                case 1:
                    instructorService.printInstructorInfo(id);
                    break;
                case 2:
                    List<ClientDTO> clientList = instructorService.printClientInfoToInstructor(id);
                    if(clientList.isEmpty()){
                        System.out.println("수강신청한 회원이 없습니다.");
                    }else {
                        System.out.println(clientList);
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

    public void instructorUpdateInfoMenu(){
        while (true){
            menuView.updateClientMenu();
            int updateMenuNum = inputReader.selectMenuNum();
            switch (updateMenuNum){
                case 1:
                case 2:
                case 3:
                case 4:
                    instructorService.updateInstructorInfo(updateMenuNum);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 숫자를 입력했습니다.\n다시 입력해주세요.");
                    break;

            }
        }
    }
}



