package com.algorithm2024.letcode;

import java.util.Arrays;

public class Exam20240228_q128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        // 0, 1, 1, 2

        int answer = 1;

        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] == nums[i - 1] + 1) {
                temp += 1;
                answer = Math.max(answer, temp);
            } else {
                temp = 1;
            }
        }

        return answer;
    }
}
