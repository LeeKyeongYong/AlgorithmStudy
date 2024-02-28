package com.algorithm2024.letcode;

public class Exam20240228_q70 {
    public int climbStairs(int n) {
        int[] dp = new int[46];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;

        for (int i = 5; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
