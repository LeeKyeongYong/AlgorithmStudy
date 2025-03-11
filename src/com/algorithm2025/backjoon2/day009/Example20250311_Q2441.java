package com.algorithm2025.backjoon2.day009;

import java.util.Scanner;

public class Example20250311_Q2441 { // 별 찍기 -4
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                sb.append(" ".repeat(i))   // 공백 추가
                        .append("*".repeat(N - i)) // 별 추가
                        .append("\n");  // 줄바꿈 추가
            }

            System.out.print(sb); // 한 번에 출력하여 성능 향상
        }
    }
}
