package com.algorithm2025.backjoon2.day002;

import java.util.Scanner;

public class Eample20250303_Q10039 { // 평균점수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        // 5개의 점수 입력받고 처리
        for (int i = 0; i < 5; i++) {
            int score = Math.max(sc.nextInt(), 40); // 점수가 40 미만이면 40으로 처리
            sum += score;
        }

        // 평균 점수 출력
        System.out.println(sum / 5);
    }
}