package com.algorithm2025.backjoon.day017;

import java.util.Scanner;

public class Example20250228_q5 { // 25314 코딩은 체육과목 입니다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N / 4; i++) {
            sb.append("long ");
        }
        sb.append("int");

        System.out.println(sb);
    }
}
