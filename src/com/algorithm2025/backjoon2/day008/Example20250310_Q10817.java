package com.algorithm2025.backjoon2.day008;

import java.util.Scanner;

public class Example20250310_Q10817 { // 세수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // 두 번째로 큰 값을 찾는 방법
        int middle = (a > b) ? (a < c ? a : (b > c ? b : c)) : (b < c ? b : (a > c ? a : c));

        System.out.println(middle);
    }
}
