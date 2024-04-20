package com.javabook.algoritm1;

public class Example20240420_1 {
    static int solution(int[] schedules) {
        int[] dp = new int[schedules.length];

        dp[0] = schedules[0];
        dp[1] = Math.max(dp[0], schedules[1]);

        for (int i = 2; i < schedules.length; i++) {
            dp[i] = Math.max(dp[i - 2] + schedules[i], dp[i - 1]);
        }

        return dp[schedules.length - 1];
    }

    public static void main(String[] args) {
        int[] schedules = {30, 30, 60, 90, 60, 15, 15, 60};

        // 210
        System.out.println(solution(schedules));
    }
}
