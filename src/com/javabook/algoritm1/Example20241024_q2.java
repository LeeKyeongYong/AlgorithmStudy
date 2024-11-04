package com.javabook.algoritm1;

import java.util.Scanner;

public class Example20241024_q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        long[] dp = new long[16];
        dp[0] = 2;
        dp[1] = 3; // dp[0] + 2^0
        dp[2] = 5; // dp[1] + 2^1
        dp[3] = 9;
        dp[4] = 17;

        for (int i = 1; i <= 15; i++) {
            dp[i] = dp[i - 1] + (int) Math.pow(2, i - 1);
        }

        System.out.println(dp[num] * dp[num]);
    }
}