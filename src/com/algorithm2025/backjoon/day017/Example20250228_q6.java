package com.algorithm2025.backjoon.day017;

import java.util.Scanner;

public class Example20250228_q6 { // 9086 문자열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String text = sc.nextLine();
            sb.append(text.charAt(0)).append(text.charAt(text.length() - 1)).append("\n");
        }

        System.out.print(sb); // 한 번에 출력하여 성능 향상
    }
}
