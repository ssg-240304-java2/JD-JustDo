package com.justdo.climbing.repository;

import com.justdo.climbing.dto.member.ClientDTO;
import com.justdo.climbing.dto.member.InstructorDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClimbingRepository {

    private static ClimbingRepository instance;

    private List<InstructorDTO> instructorDTOList=null;
    private List<ClientDTO> clientDTOList=null;
    private Scanner scanner = new Scanner(System.in);
//    private InstructorDTO

    public ClimbingRepository() {
        instructorDTOList = new ArrayList<>();
        clientDTOList = new ArrayList<>();
    }

    public static ClimbingRepository getInstance(){
        // new를 사용할경우 등록하 정보가 없어져서 static을 활용해서 사용
        if(instance == null){
            instance = new ClimbingRepository();
        }
        return instance;
    }

    public int getInstructorListSize(){
        return instructorDTOList.size();
    }

    public List<ClientDTO> getClientListInfoList(){
        return clientDTOList;
    }

    public boolean isContainsInstructorPhoneNumber(String inputInstructorPhoneNumber){
        // 강사리스트에 핸드폰 번호가 이미 등록되어있는지 확인
        for (InstructorDTO instructorDTO : instructorDTOList){
            if(instructorDTO.getMemberPhone().equals(inputInstructorPhoneNumber)){
                return true;
            }
        }
        return false;
    }

    public boolean isContainsUpdateInstructorPhoneNumber(String inputInstructorPhoneNumber){
        // 강사리스트에 핸드폰 번호가 이미 등록되어있는지 확인
        for (InstructorDTO instructorDTO : instructorDTOList){
            if(instructorDTO.getMemberPhone().equals(inputInstructorPhoneNumber)){
                return true;
            }
        }
        return false;
    }

    public void addInstructorDTOList(InstructorDTO inputInstructorInfo){

        // 핸드폰번호 제외한 나머지 정보등록
        System.out.print("강의할 등급을 입력해주세요 : ");
        char grade = scanner.nextLine().charAt(0);
        inputInstructorInfo.setInstructorGrade(grade);

        //인덱스 추가
        inputInstructorInfo.setInstructorNo(getInstructorListSize()+1);

        System.out.print("강사명을 입력해주세요 : ");
        String name = scanner.nextLine();
        inputInstructorInfo.setMemberName(name);

        System.out.print("강사의 성별을 입력해주세요(f : 여성 / m : 남성) : ");
        boolean gender = ("f".equals(scanner.nextLine().charAt(0)))?true:false;
        inputInstructorInfo.setMemberGender(gender);

        System.out.print("강사의 나이를 입력해주세요 : ");
        int age = scanner.nextInt();
        inputInstructorInfo.setMemberAge(age);
        scanner.nextLine();

        //TODO:선택하게될 센터 목록 정하기
        inputInstructorInfo.setCenter(1);

        instructorDTOList.add(inputInstructorInfo);
    }

    public List<InstructorDTO> getInstructorDTOList(){
        return instructorDTOList;
    }

    public void editInstructorInfo(InstructorDTO inputInstructorInfo){

        System.out.print("수정할 강의 등급을 입력해주세요 : ");
        char grade = scanner.nextLine().charAt(0);
        inputInstructorInfo.setInstructorGrade(grade);

        //인덱스 추가
        inputInstructorInfo.setInstructorNo(getInstructorListSize()+1);

        System.out.print("수정할 강사명을 입력해주세요 : ");
        String name = scanner.nextLine();
        inputInstructorInfo.setMemberName(name);

        System.out.print("수정할 강사의 성별을 입력해주세요(f : 여성 / m : 남성) : ");
        boolean gender = ("f".equals(scanner.nextLine().charAt(0)))?true:false;
        inputInstructorInfo.setMemberGender(gender);
//        scanner.nextLine();
        System.out.print("수정할 강사의 나이를 입력해주세요 : ");
        int age = scanner.nextInt();
        inputInstructorInfo.setMemberAge(age);
        scanner.nextLine();

        //TODO:선택하게될 센터 목록 정하기
        inputInstructorInfo.setCenter(1);

        for (InstructorDTO instructorDTO : instructorDTOList){
            if(instructorDTO.getMemberPhone().equals(inputInstructorInfo.getMemberPhone())){
                instructorDTO=inputInstructorInfo;
                break;
            }
        }

    }

    public List<InstructorDTO> getGradeInstriuctorList(char grade){

        List<InstructorDTO> instructorDTOS = new ArrayList<>();
        for(InstructorDTO instructorDTO : instructorDTOList){
            if(grade == instructorDTO.getInstructorGrade()){
                instructorDTOS.add(instructorDTO);
            }
        }
        return instructorDTOS;
    }


}
