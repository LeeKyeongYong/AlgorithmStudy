package com.algorithm2025.backjoon2.day007;

import java.util.Scanner;

public class Example20250308_Q17362 { // 수학은 체육과목입니다 2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() % 8;

        int result = switch (n) {
            case 1 -> 1;
            case 0, 2 -> 2;
            case 3, 7 -> 3;
            case 4, 6 -> 4;
            default -> 5;
        };

        System.out.println(result);
    }
}