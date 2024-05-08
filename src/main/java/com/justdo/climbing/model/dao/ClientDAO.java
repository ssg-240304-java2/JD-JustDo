package com.justdo.climbing.model.dao;

import com.justdo.climbing.model.dto.member.ClientDTO;

import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    private List<ClientDTO> clientList = null;
    private static ClientDAO instance;

    public static ClientDAO getInstance(){
        // new를 사용할경우 등록하 정보가 없어져서 static을 활용해서 사용
        if(instance == null){
            instance = new ClientDAO();
        }
        return instance;
    }

    public ClientDAO() {
        clientList = new ArrayList<>();
    }


    public List<ClientDTO> getClientList(){
        return clientList;
    }

    public void addClient(ClientDTO clientDTO){
        clientList.add(clientDTO);
    }
}
