package com.algorithm2024.programers07;

import java.util.Scanner;

public class Example20241121_q11653 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                System.out.println(i);
                n /= i;
            }
        }

        if (n != 1) {
            System.out.println(n);
        }
    }
}
