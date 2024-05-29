package com.algorithm2024.programers03;

import java.util.stream.IntStream;

public class Example20240529_05 {
    public int solution(int n) {
        int mod = 1000000007;
        if (n == 1) return 2;
        if (n == 2) return 3;

        int[] dp = new int[n + 1];
        dp[1] = 2;
        dp[2] = 3;

        IntStream.range(3, n + 1).forEach(i -> {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
            if (i % 2 != 0) {
                dp[i] = (dp[i] + dp[i - 1]) % mod;
            }
        });

        return dp[n];
    }
    public static void main(String[] args) {
        Example20240529_05 sol = new Example20240529_05();
        int n = 5;
        System.out.println(sol.solution(n));  // Example usage
    }
}
