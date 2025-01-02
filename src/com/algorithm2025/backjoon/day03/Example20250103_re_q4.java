package com.algorithm2025.backjoon.day03;

import java.util.Scanner;

public class Example20250103_re_q4 {  //2025년 알고리즘 재복습버전 04 A+B -7
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            result.append("Case #").append(i).append(": ").append(A + B).append("\n");
        }
        sc.close();
        System.out.print(result);  // 한번에 출력
    }
}
