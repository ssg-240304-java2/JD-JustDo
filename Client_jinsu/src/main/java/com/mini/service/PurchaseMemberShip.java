package com.mini.service;

import com.mini.controller.ResultPrinter;
import com.mini.model.dto.member.ClientDTO;
import com.mini.model.dto.product.ProductDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class PurchaseMemberShip {
    static ResultPrinter resultPrinter = new ResultPrinter();
    static ClientDTO loggedMember;
    private static Scanner sc = new Scanner(System.in);
    static ArrayList<ClientDTO> clientDTOList = new ArrayList<>();
    ProductDTO productDTO = new ProductDTO();
    public static void purchase(ClientDTO loggedMember) {

        while (true) {
            System.out.println("""
                    ========================================
                    이용권 구매창입니다.
                    1  /  3  /  6 개월 중 하나를 선택하세요.
                    구매를 원하지 않으시면 ' 9 '를 눌러주세요
                    ========================================
                        숫자를 입력해주세요 :
                    """);
            int command = sc.nextInt();
            sc.nextLine();

            switch (command) {
                case 1:
                    System.out.println("1개월 이용권을 선택하셨습니다.");
                    //물품 재고 -1
                    loggedMember.setDuration(loggedMember.getDuration() + 1);
                    resultPrinter.showResult(5, clientDTOList, loggedMember); //내 정보 출력
                    return;
                case 3:
                    System.out.println("3개월 이용권을 선택하셨습니다.");
                    loggedMember.setDuration(loggedMember.getDuration() + 3);
                    resultPrinter.showResult(5, clientDTOList, loggedMember); //내 정보 출력
                    return;
                case 6:
                    System.out.println("6개월 이용권을 선택하셨습니다.");
                    loggedMember.setDuration(loggedMember.getDuration() + 6);
                    resultPrinter.showResult(5, clientDTOList, loggedMember); //내 정보 출력
                    return;
                case 9:
                    System.out.println("이전으로 돌아갑니다.");
                    return;
                default:
                    System.out.println("다시 선택해주세요");
            }
        }
    }
}
