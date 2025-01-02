package com.algorithm2025.backjoon.day03;

import java.util.Scanner;

public class Example20250103_re_q3 {  //2025년 알고리즘 재복습버전 03 A+B -5
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                int A = sc.nextInt();
                int B = sc.nextInt();
                if (A == 0 && B == 0) {
                    break;
                }
                System.out.println(A + B);
            }
            sc.close();
        }
    }
}
