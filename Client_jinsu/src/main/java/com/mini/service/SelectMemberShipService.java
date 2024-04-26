package com.mini.service;

import com.mini.controller.ResultPrinter;
import com.mini.model.dto.member.ClientDTO;
import com.mini.model.dto.product.ProductDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SelectMemberShipService {
    static ResultPrinter resultPrinter = new ResultPrinter();
    static ClientDTO loggedMember;
    private static Scanner sc = new Scanner(System.in);
    static ArrayList<ClientDTO> clientDTOList = new ArrayList<>();
    static ProductDTO productDTO = new ProductDTO();
    static List<String> instructorNo = Arrays.asList("1", "2", "3", "4", "5");

    public static void purchase(ClientDTO loggedMember) {

        while (true) {
            System.out.println("""
                    ========================================
                    이용권 구매창입니다.
                    1  /  3  /  6 개월 중 하나를 선택하세요.
                    구매를 원하지 않으시면 ' 9 '를 눌러주세요
                    ========================================
                        숫자를 입력해주세요 :""");
            int command;
            try {
                command = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자 형식이 아닙니다. 다시 입력해주세요");
                continue;
            }

            switch (command) {
                case 1:
                    System.out.println("1개월 이용권을 선택하셨습니다.");
                    //물품 재고 -1
                    loggedMember.setDuration(loggedMember.getDuration() + 1);
                    resultPrinter.showResult(5, clientDTOList, loggedMember); //내 정보 출력
                    break;
                case 3:
                    System.out.println("3개월 이용권을 선택하셨습니다.");
                    loggedMember.setDuration(loggedMember.getDuration() + 3);
                    resultPrinter.showResult(5, clientDTOList, loggedMember); //내 정보 출력
                    break;
                case 6:
                    System.out.println("6개월 이용권을 선택하셨습니다.");
                    loggedMember.setDuration(loggedMember.getDuration() + 6);
                    resultPrinter.showResult(5, clientDTOList, loggedMember); //내 정보 출력
                    break;
                case 9:
                    System.out.println("이전으로 돌아갑니다.");
                    return;
                default:
                    System.out.println("다시 선택해주세요");
            }
            break;
        }

//        productDTO.setProductQuantity(productDTO.getProductQuantity() - 1); //물품 재고 -1

        if (loggedMember.getInstructorNo() == 0) { //강사 번호가 0이면서 지정되어있지 않으면
            while (true) {
                System.out.println("""
                        원하시는 강사의 번호를 입력해주세요 (5번까지)
                        이전으로 돌아시려면 ' 9 '를 입력해주세요
                        """);
                int instructorNumber;
                try {
                    instructorNumber = Integer.parseInt(sc.nextLine());
                    if (instructorNumber == 9) {
                        return;
                    }
                    if (0 < instructorNumber && instructorNumber <= instructorNo.size()) {
                        System.out.println("=====" + instructorNumber + "번 강사를 선택하셨습니다.=====");
                        loggedMember.setInstructorNo(instructorNumber);
                        resultPrinter.showResult(5, clientDTOList, loggedMember); //내 정보 출력
                    }
                } catch (NumberFormatException e) {
                    System.out.println("올바른 숫자 형식이 아닙니다. 다시 입력해주세요");
                    sc.nextLine();
                    continue;
                }
                break;
            }
        }
    }
}
