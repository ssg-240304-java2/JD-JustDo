package climbingApplication;

import climbingApplication.DTO.Member.ClientDTO;
import climbingApplication.DTO.Member.InstructorDTO;

import java.util.ArrayList;

public class Repository {

    ArrayList<ClientDTO> clientDTOList = new ArrayList<>();

    {
        clientDTOList.add(new ClientDTO("박진수", "11111111", 1, false, 29, 1, 1));
        clientDTOList.add(new ClientDTO("안준렬", "22222222", 1, false, 29, 2, 2));
        clientDTOList.add(new ClientDTO("이은솔", "33333333", 1, true, 29, 3, 2));
    }

    ArrayList<InstructorDTO> instructorDTOList = new ArrayList<>();

    {
        instructorDTOList.add(new InstructorDTO("장준영", "44444444", 1, false, 29, 1, 'A'));
        instructorDTOList.add(new InstructorDTO("이정훈", "55555555", 1, false, 29, 2, 'B'));
    }

    public ArrayList<ClientDTO> getClientDTOList() {
        return clientDTOList;
    }

    public ArrayList<InstructorDTO> getInstructorDTOList() {
        return instructorDTOList;
    }
}
