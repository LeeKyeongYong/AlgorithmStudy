package com.algorithm2025.backjoon.day03;

import java.util.Scanner;

public class Example20250103_re_q5 {  //2025년 알고리즘 재복습버전 05 A+B - 8
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            sc.close();
            result.append("Case #").append(i).append(": ").append(A).append(" + ").append(B)
                    .append(" = ").append(A + B).append("\n");
        }

        System.out.print(result);  // 한번에 출력
    }
}
