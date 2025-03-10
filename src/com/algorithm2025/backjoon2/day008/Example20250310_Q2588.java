package com.algorithm2025.backjoon2.day008;

import java.util.Scanner;

public class Example20250310_Q2588 { // 곱셈
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();

        int sum = 0;
        int su = 1;

        // 두 번째 숫자의 각 자리에 대해서 곱셈 수행
        for (int i = 0; i < 3; i++) {
            int temp = second % 10;
            System.out.println(first * temp);
            sum += first * temp * su;
            second /= 10;
            su *= 10;
        }
        System.out.println(sum);
    }
}
