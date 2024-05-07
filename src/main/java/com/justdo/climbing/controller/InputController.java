package com.justdo.climbing.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputController {
    private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public int selectMenuNum(){
        // TODO : Scanner를 Controller에 작성한 이유? view에 넣고 파라미터로 받아도 되는지?
//        Scanner sc = new Scanner(System.in);
        int num;
        while(true){
            try{
                num = Integer.parseInt(bf.readLine());

                // TODO:try-catch사용하는데 비교할 필요 있는지?
                if(Integer.class.isInstance(num)){
                    return num;
                }
            } catch (Exception e){
                System.out.println("정수만 입력하세요.");
            }
        }
    }

    public String inputString(){
        String str;
        try {
            str = bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;
    }

}
