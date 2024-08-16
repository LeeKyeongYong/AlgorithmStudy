package com.algorithm2024.letcode5;

import java.util.Scanner;

public class Example20240816_q1614 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long count = sc.nextLong();
        long answer = n - 1;

        if (count > 0) {
            if (n % 4 == 1) {
                answer += 8 * count;
            } else {
                answer += count / 2 * 8 + count % 2 * (8 - (n - 1) * 2);
            }
        }

        System.out.println(answer);
    }
}
