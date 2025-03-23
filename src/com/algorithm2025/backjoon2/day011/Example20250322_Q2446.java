package com.algorithm2025.backjoon2.day011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example20250322_Q2446 { // 별찍기 - 9
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 상단 피라미드 (역삼각형)
        for (int i = 0; i < N; i++) {
            sb.append(" ".repeat(i))
                    .append("*".repeat(2 * (N - i) - 1))
                    .append("\n");
        }

        // 하단 피라미드
        for (int i = 1; i < N; i++) {
            sb.append(" ".repeat(N - i - 1))
                    .append("*".repeat(2 * i + 1))
                    .append("\n");
        }

        System.out.print(sb);
    }
}
