package com.algorithm2025.backjoon2.day008;

import java.util.Scanner;

public class Example20250310_Q2884 { //알람시계
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int H = sc.nextInt();
            int M = sc.nextInt();

            // 45분 전으로 조정
            int totalMinutes = H * 60 + M - 45;
            H = (totalMinutes / 60 + 24) % 24; // 음수 방지 (0시에서 -45분 시 예외처리)
            M = totalMinutes % 60;

            System.out.println(H + " " + M);
        }
    }
}
