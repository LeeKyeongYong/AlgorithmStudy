package com.algorithm2024.letcode1;

public class Example20240430_q300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < dp.length; i++) {
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
