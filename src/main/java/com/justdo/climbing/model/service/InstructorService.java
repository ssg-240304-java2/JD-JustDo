package com.justdo.climbing.model.service;

import com.justdo.climbing.controller.InputReader;
import com.justdo.climbing.controller.InputReaderFactory;
import com.justdo.climbing.model.dto.member.ClientDTO;
import com.justdo.climbing.model.dto.member.InstructorDTO;
import com.justdo.climbing.model.dao.ClientDAO;
import com.justdo.climbing.model.dao.InstructorDAO;
import com.justdo.climbing.model.service.common.CommonService;

import java.util.ArrayList;
import java.util.List;

public class InstructorService {

    private InstructorDAO instructorDAO = InstructorDAO.getInstance();
    private ClientDAO clientDAO = ClientDAO.getInstance();
    private CommonService commonService = new CommonService();
    private InputReader inputReader = InputReaderFactory.getInputReader();

    public void addInstructorInfo(){
        while (true){
            // 핸드폰 번호를 입력
            System.out.print("(010, - 제외한)휴대폰 번호 8자리를 입력하세요 : ");
            String phoneNum = inputReader.inputString();

            // 중복확인
            boolean checkPhone = commonService.checkPhonNumber(phoneNum);
            boolean isContains = commonService.isContainsInstructorList(phoneNum);
            if (isContains){
                System.out.println("이미 등록되어있는 핸드폰 번호입니다.");
            }

            if(checkPhone && !isContains){
                InstructorDTO instructorDTO= new InstructorDTO();
                // 데이터 입력받기
                instructorDTO.setMemberPhone(phoneNum);
                instructorDTO.setInstructorNo(instructorDAO.getInstructorList().size()+1);

                // TODO:view, controller로 빼기 필요
                System.out.print("나이를 입력해주세요. : ");
                int age = inputReader.inputIntValue();
                instructorDTO.setMemberAge(age);

                System.out.print("성별을 입력해주세요.(여성:f, 남성:m) : ");
                String gender = inputReader.inputString().toLowerCase();
                instructorDTO.setMemberGender(gender.charAt(0)=='m');

                System.out.print("이름을 입력해주세요. : ");
                String name = inputReader.inputString();
                instructorDTO.setMemberName(name);

                System.out.print("강의하실 등급을 입력해주세요:");
                char grade = inputReader.inputString().toUpperCase().charAt(0);
                instructorDTO.setInstructorGrade(grade);

                instructorDAO.addInstructorInfo(instructorDTO);
                return;
            }
        }

    }

    public void printInstructorInfo(String id){
        if(id != null){
            List<InstructorDTO> instructorList = new ArrayList<>();
            for(InstructorDTO instructorDTO : instructorDAO.getInstructorList()){
                if(id.equals(instructorDTO.getMemberPhone())){
                    instructorList.add(instructorDTO);

                    break;
                }
            }

            if(instructorList.isEmpty()){
                System.out.println("일치하는 강사정보가 없습니다.");
            }else{
                System.out.println(instructorList);
            }

        }else {
            System.out.println(instructorDAO.getInstructorList());
        }

    }

    public List<ClientDTO> printClientInfoToInstructor(String id){
        int instructorNo = 0;
        for (InstructorDTO instructorDTO : instructorDAO.getInstructorList()){
            if(id.equals(instructorDTO.getMemberPhone())){
                instructorNo = instructorDTO.getInstructorNo();
                break;
            }
        }

        List<ClientDTO> clientList = new ArrayList<>();
        for(ClientDTO clientDTO : clientDAO.getClientList()){
            if(instructorNo == clientDTO.getInstructorNo()){
                clientList.add(clientDTO);
            }
        }
        return clientList;
    }

    public void updateInstructorInfo(int menuNum){
        // TODO: 핸드폰번호 체크후 수정 메뉴 표시하는건 어떤지?
        while (true){
            // 핸드폰 번호를 입력
            System.out.print("(010, - 제외한)휴대폰 번호 8자리를 입력하세요 : ");
            String phoneNum = inputReader.inputString();

            // 중복확인
            boolean checkPhone = commonService.checkPhonNumber(phoneNum);
            boolean isContains = commonService.isContainsInstructorList(phoneNum);
            if(!isContains){
                System.out.println("입력하신 핸드폰 번호로 등록된 회원이 없습니다.");
            }
            if(checkPhone && isContains){
                //TODO:따로 분리할까..?
                for (InstructorDTO instructorDTO : instructorDAO.getInstructorList()){
                    if(phoneNum.equals(instructorDTO.getMemberPhone())){
                        // 입력단에서 이미 switch-case로 메뉴에 있는 값만 넘겨주기 때문에 탈퇴는 else로 작성
                        if(menuNum == 1){
                            System.out.print("변경할 이름을 입력해주세요. : ");
                            String clientName = inputReader.inputString();
                            instructorDTO.setMemberName(clientName);
                            return;
                        } else if (menuNum == 2) {
                            System.out.print("변경할 성별을 입력해주세요.(여성:f, 남성:m) : ");
                            char clientGender = inputReader.inputString().toUpperCase().charAt(0);
                            instructorDTO.setMemberGender(clientGender=='M');
                            return;
                        } else if (menuNum==3) {
                            System.out.print("변경할 나이를 입력해주세요. : ");
                            int clientAge = inputReader.inputIntValue();
                            instructorDTO.setMemberAge(clientAge);
                            return;
                        }else {
                            instructorDAO.getInstructorList().remove(instructorDTO);
                            return;
                        }
                    }
                }
            }
        }
    }
}
