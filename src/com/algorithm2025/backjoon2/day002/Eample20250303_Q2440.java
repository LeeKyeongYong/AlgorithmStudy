package com.algorithm2025.backjoon2.day002;

import java.util.Scanner;

public class Eample20250303_Q2440 { // 별찍기 3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // N부터 1까지 감소하며 별을 출력
        for (int i = N; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
