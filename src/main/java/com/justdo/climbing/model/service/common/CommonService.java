package com.justdo.climbing.model.service.common;

import com.justdo.climbing.model.dto.member.ClientDTO;
import com.justdo.climbing.model.dto.member.InstructorDTO;
import com.justdo.climbing.model.dao.ClientDAO;
import com.justdo.climbing.model.dao.InstructorDAO;

public class CommonService {

    private final String ADMIN_LOGIN_ID = "admin";
    private final String ADMIN_LOGIN_PASSWORD = "admin";
    private static final String CHECK_PHONE_NUMBER_HYPHEN = "^[\\d]{8}+$";
    private ClientDAO clientDAO = ClientDAO.getInstance();
    private InstructorDAO instructorDAO = InstructorDAO.getInstance();

    /**
     * 로그인 처리 메소드
     * @param auth : 선택한 권한
     * @param id : 입력한 아이디 (관리자 : 아이디, 강사/회원 : 핸드폰번호)
     * @param password : 입력한 패스워드 (관리자 : 비밀번호, 강사/회원 : 이름)
     *
     * @return 회원 아이디(관리자 : 아이디, 강사/회원 : 핸드폰번호)
     * */
    public String login(String auth, String id, String password){
        
        if("ADMIN".equals(auth)){ // 관리자 권한 로그인
            if (!ADMIN_LOGIN_ID.equals(id)){
                System.out.println("아이디가 잘못 입력하셨습니다.");
                return null;
            }
            if(!ADMIN_LOGIN_PASSWORD.equals(password)){
                System.out.println("비밀번를 잘못 입력하셨습니다.");
                return null;
            }
        } else if ("CLIENT".equals(auth)) {
            for (ClientDTO clientDTO : clientDAO.getClientList()){
                if(id.equals(clientDTO.getMemberPhone())){
                    if(password.equals(clientDTO.getMemberName())){
                        // 일치하는 계정 발견
                        break;
                    }else {
                        System.out.println("비밀번호가 일치하지 않습니다.");
                        return null;
                    }
                }else {
                    System.out.println("입력하신 정보와 일치하는 회원이 없습니다.");
                    return null;
                }
            }
        }else if("INSTRUCTOR".equals(auth)){
            for (InstructorDTO instructorDTO : instructorDAO.getInstructorList()){
                if(id.equals(instructorDTO.getMemberPhone())){
                    if(password.equals(instructorDTO.getMemberName())){
                        // 일치하는 계정 발견
                        break;
                    }else {
                        System.out.println("비밀번호가 일치하지 않습니다.");
                        return null;
                    }
                }else {
                    System.out.println("입력하신 정보와 일치하는 회원이 없습니다.");
                    return null;
                }
            }
        }

        return id;
    }


    /**
     * 핸드폰 번호 입력체크 메소드
     * 1. 핸드폰입력여부 체크
     * 2. 핸드폰번호 010제외 8자 입력 했는지 체크
     *
     * @param inputPhoneNumber 입력한 핸드폰 번호
     * @return 핸드폰 입력체크 결과
     * */
    public boolean checkPhonNumber(String inputPhoneNumber){

        if(inputPhoneNumber== null || inputPhoneNumber.isBlank()){
            System.out.println("핸드폰번호를 입력해주세요.");
            return false;
        }else if(!inputPhoneNumber.matches(CHECK_PHONE_NUMBER_HYPHEN)){
            System.out.println("핸드폰번호를 잘못입력하셨습니다.\n010과 하이픈을 제외한 8자를 입력해주세요.");
            return false;
        } else {
            return true;
        }
    }

    /**
     * 핸드폰 번호 중복검사
     * - clientList에 핸드폰 번호가 등록되어있는지 검사
     * @param clientPhoneNumber 회원 핸드폰번호
     * @return 핸드폰 번호 중복검사 결과 (true:존재함, false: 존재 안함)
     * */
    public boolean isContainsClientList(String clientPhoneNumber){
        // 회원리스트에 핸드폰 번호가 이미 등록되어있는지 확인
        for (ClientDTO clientDTO : clientDAO.getClientList()){
            if(clientPhoneNumber.equals(clientDTO.getMemberPhone())){
                return true;
            }
        }
        return false;
    }

    public boolean isContainsInstructorList(String instructorPhoneNumber){
        // 강사리스트에 핸드폰 번호가 이미 등록되어있는지 확인
        for (InstructorDTO instructorDTO : instructorDAO.getInstructorList()){
            if(instructorPhoneNumber.equals(instructorDTO.getMemberPhone())){
                return true;
            }
        }
        return false;
    }
}
