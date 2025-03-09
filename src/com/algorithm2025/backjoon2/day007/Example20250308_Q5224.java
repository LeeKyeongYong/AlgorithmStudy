package com.algorithm2025.backjoon2.day007;

import java.util.Scanner;

public class Example20250308_Q5224 { // 입실관리
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(sc.next().toLowerCase()).append("\n");
            }
            System.out.print(sb);
        }
    }
}
