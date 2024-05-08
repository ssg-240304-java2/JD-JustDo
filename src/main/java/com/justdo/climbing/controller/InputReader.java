package com.justdo.climbing.controller;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
    private final BufferedReader reader;

    public InputReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int selectMenuNum() {
        int menuNum = 0;

        while (true) {
            try {
                System.out.print("메뉴를 선택해 주세요 : ");
                String menuStr = reader.readLine();
                menuNum = Integer.parseInt(menuStr);

                if (menuNum > 0) {
                    break;
                } else {
                    System.out.println("정수를 입력해주세요.");
                }
            } catch (IOException e) {
                System.out.println("입력 오류가 발생했습니다.");
            } catch (NumberFormatException e) {
                System.out.println("정수를 입력해주세요.");
            }
        }
        return menuNum;
    }

    public String inputString () {

        String inputStr = "";

        while (true) {
            try {
                inputStr = reader.readLine();

                if(inputStr != null){
                    break;
                }else{
                    System.out.println("입력된 값이 없습니다. 다시 입력해주세요 : ");
                }

            } catch (IOException e) {
                System.out.println("입력 오류가 발생했습니다.");
            }
        }
        return inputStr;
    }

    public int inputIntValue() {
        int intVal = 0;

        while (true) {
            try {

                String menuStr = reader.readLine();
                intVal = Integer.parseInt(menuStr);

                if (intVal > 0) {
                    break;
                } else {
                    System.out.println("정수를 입력해주세요.");
                }
            } catch (IOException e) {
                System.out.println("입력 오류가 발생했습니다.");
            } catch (NumberFormatException e) {
                System.out.println("정수를 입력해주세요.");
            }
        }
        return intVal;
    }

    /**
     * BufferedReader를 close 하도록 작성
     * */
    public void close() {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
