package com.algorithm2025.backjoon2.day007;

import java.util.Scanner;

public class Example20250308_Q2562 { // 최대값
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int max = sc.nextInt();
            int maxIndex = 1;

            for (int i = 2; i <= 9; i++) {
                int currentNumber = sc.nextInt();
                if (currentNumber > max) {
                    max = currentNumber;
                    maxIndex = i;
                }
            }

            System.out.println(max);
            System.out.println(maxIndex);
        }
    }
}
