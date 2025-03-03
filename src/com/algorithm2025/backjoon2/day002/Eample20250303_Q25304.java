package com.algorithm2025.backjoon2.day002;

import java.util.Scanner;

public class Eample20250303_Q25304 { // 영수증
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();  // 총액 입력
        int N = sc.nextInt();      // 품목 개수 입력

        int sum = 0; // 계산된 합계

        // 각 품목에 대한 가격과 수량 입력받아 합산
        for (int i = 0; i < N; i++) {
            int price = sc.nextInt();  // 품목의 가격
            int quantity = sc.nextInt();  // 품목의 수량
            sum += price * quantity;  // 총액에 더함
        }

        // 총액이 맞는지 확인 후 출력
        System.out.println(total == sum ? "Yes" : "No");
    }
}
