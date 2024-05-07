package com.justdo.climbing.model.dao;

import com.justdo.climbing.model.dto.member.InstructorDTO;

import java.util.ArrayList;
import java.util.List;

public class InstructorDAO {

    private List<InstructorDTO> instructorList=null;
    private static InstructorDAO instance;

    public static InstructorDAO getInstance(){
        // new를 사용할경우 등록하 정보가 없어져서 static을 활용해서 사용
        if(instance == null){
            instance = new InstructorDAO();
        }
        return instance;
    }

    public InstructorDAO() {
        instructorList = new ArrayList<>();
    }

    public List<InstructorDTO> getInstructorList(){
        return instructorList;
    }

    public void addInstructorInfo(InstructorDTO instructorDTO){
        instructorList.add(instructorDTO);
    }
}

