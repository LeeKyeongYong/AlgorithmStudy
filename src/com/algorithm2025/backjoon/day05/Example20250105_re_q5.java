package com.algorithm2025.backjoon.day05;

import java.util.Scanner;

public class Example20250105_re_q5 { // 2475 검증수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 한 줄에 입력받아 바로 합산하여 결과 출력
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += Math.pow(sc.nextInt(), 2);
        }

        // 합산된 값을 10으로 나눈 나머지 출력
        System.out.println(sum % 10);
    }
}
