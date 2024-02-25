package com.algorithm2024.letcode;

public class Exam20240205_q53 {
    public int maxSubArray(int[] nums) {
        int answer = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            if (sum >= 0) {
                sum += num;
            } else {
                sum = num;
            }

            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
