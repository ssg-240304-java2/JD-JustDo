package com.justdo.climbing.model.service;

import com.justdo.climbing.controller.InputReader;
import com.justdo.climbing.controller.InputReaderFactory;
import com.justdo.climbing.model.dto.member.ClientDTO;
import com.justdo.climbing.model.dao.ClientDAO;
import com.justdo.climbing.model.service.common.CommonService;

import java.util.ArrayList;
import java.util.List;

public class ClientSerivce {

    private ClientDAO clientDAO = ClientDAO.getInstance();

    private CommonService commonService = new CommonService();
    private InputReader inputReader = InputReaderFactory.getInputReader();

    public void addClientInfo(){
        while (true){
            // 핸드폰 번호를 입력
            System.out.print("(010, - 제외한)휴대폰 번호 8자리를 입력하세요 : ");
            String phoneNum = inputReader.inputString();

            // 중복확인
            boolean checkPhone = commonService.checkPhonNumber(phoneNum);
            boolean isContains = commonService.isContainsClientList(phoneNum);
            if (isContains){
                System.out.println("이미 등록되어있는 핸드폰 번호입니다.");
            }



            if(checkPhone && !isContains){
                ClientDTO clientDTO= new ClientDTO();
                // 데이터 입력받기
                clientDTO.setMemberPhone(phoneNum);

                // view controller로 빼기 필요
                System.out.print("나이를 입력해주세요. : ");
                int age = inputReader.inputIntValue();
                clientDTO.setMemberAge(age);

                System.out.print("성별을 입력해주세요.(여성:f, 남성:m) : ");
                String gender = inputReader.inputString().toLowerCase();
                clientDTO.setMemberGender(gender.charAt(0)=='m');

                System.out.print("이름을 입력해주세요. : ");
                String name = inputReader.inputString();
                clientDTO.setMemberName(name);

                clientDAO.addClient(clientDTO);
                return;
            }
        }

    }

    public void updateClientInfo(int menuNum){
        // TODO: 핸드폰번호 체크후 수정 메뉴 표시하는건 어떤지?
        while (true){
            // 핸드폰 번호를 입력
            System.out.print("(010, - 제외한)휴대폰 번호 8자리를 입력하세요 : ");
            String phoneNum = inputReader.inputString();

            // 중복확인
            boolean checkPhone = commonService.checkPhonNumber(phoneNum);
            boolean isContains = commonService.isContainsClientList(phoneNum);
            if(!isContains){
                System.out.println("입력하신 핸드폰 번호로 등록된 회원이 없습니다.");
            }
            if(checkPhone && isContains){
                //TODO:따로 분리할까..?
                for (ClientDTO clientDTO : clientDAO.getClientList()){
                    if(phoneNum.equals(clientDTO.getMemberPhone())){
                        // 입력단에서 이미 switch-case로 메뉴에 있는 값만 넘겨주기 때문에 탈퇴는 else로 작성
                        if(menuNum == 1){
                            System.out.print("변경할 이름을 입력해주세요. : ");
                            String clientName = inputReader.inputString();
                            clientDTO.setMemberName(clientName);
                            return;
                        } else if (menuNum == 2) {
                            System.out.print("변경할 성별을 입력해주세요.(여성:f, 남성:m) : ");
                            char clientGender = inputReader.inputString().toUpperCase().charAt(0);
                            clientDTO.setMemberGender(clientGender=='M');
                            return;
                        } else if (menuNum==3) {
                            System.out.print("변경할 나이를 입력해주세요. : ");
                            int clientAge = inputReader.inputIntValue();
                            clientDTO.setMemberAge(clientAge);
                            return;
                        }else {
                            clientDAO.getClientList().remove(clientDTO);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void printClientListInfo(String id){

        if(clientDAO.getClientList().isEmpty()){
            System.out.println("등록되어있는 회원정보가 없습니다.");
        } else if (id != null) {
            List<ClientDTO> resultClientList = new ArrayList<>();
            for (ClientDTO clientDTO : clientDAO.getClientList()){
                if(id.equals(clientDTO.getMemberPhone())){
                    resultClientList.add(clientDTO);

                    break;
                }
            }
            if(resultClientList.isEmpty()){
                System.out.println("회원정보를 찾을 수 없습니다.");
            }else{
                System.out.println(resultClientList);
            }
        } else{
            System.out.println(clientDAO.getClientList());
        }
    }

}
