package com.algorithm2025.backjoon2.day009;

import java.util.Scanner;

public class Example20250311_Q2444 { // 별 찍기 - 7
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            StringBuilder sb = new StringBuilder();

            // 위쪽 삼각형
            for (int i = 0; i < N; i++) {
                sb.append(" ".repeat(N - i - 1)) // 왼쪽 공백
                        .append("*".repeat(2 * i + 1)) // 별
                        .append("\n");
            }

            // 아래쪽 삼각형
            for (int i = N - 2; i >= 0; i--) {
                sb.append(" ".repeat(N - i - 1)) // 왼쪽 공백
                        .append("*".repeat(2 * i + 1)) // 별
                        .append("\n");
            }

            System.out.print(sb); // 한 번에 출력하여 성능 향상
        }
    }
}
