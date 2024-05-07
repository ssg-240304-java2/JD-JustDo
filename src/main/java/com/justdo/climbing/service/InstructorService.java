package com.justdo.climbing.service;

import com.justdo.climbing.model.dto.member.ClientDTO;
import com.justdo.climbing.model.dto.member.InstructorDTO;
import com.justdo.climbing.repository.ClimbingRepository;

import java.util.ArrayList;
import java.util.List;

public class InstructorService {
    private ClimbingRepository repository = ClimbingRepository.getInstance();

    private String USER_ID ="";

    public boolean instructorLogin(String id, String pwd){
        boolean result = true;
        for (InstructorDTO instructorDTO : repository.getInstructorDTOList()){
            if(id.equals(instructorDTO.getMemberPhone())){
                if (!pwd.equals(instructorDTO.getMemberName())){
                    System.out.println("비밀번호 오류");
                    result= true;
                    return result;
                }else {

                    result=false;
                    return result;
                }

            }
        }
        if(result){
            System.out.println("로그인 오류");
        }
        return result;
    }

    /**
     * 강사의 내정보 표시
     * */
    public void printInstructorInfo(String id){
        for(InstructorDTO instructorDTO : repository.getInstructorDTOList()){
            if(id.equals(instructorDTO.getMemberPhone())){
                System.out.println(instructorDTO.toString());
                return;
            }
        }

    }

    public void printClientInfoToInstructor(){
        int instructorNo = 0;
        for(InstructorDTO instructorDTO : repository.getInstructorDTOList()){
            if(USER_ID.equals(instructorDTO.getMemberPhone())){
                instructorNo=instructorDTO.getInstructorNo();
                break;
            }
        }

        List<ClientDTO> clientList = new ArrayList<>();
        for(ClientDTO clientDTO : repository.getClientListInfoList()){
            if(instructorNo == clientDTO.getInstructorNo()){
                System.out.println(clientDTO.toString());
            }
        }


    }
}
