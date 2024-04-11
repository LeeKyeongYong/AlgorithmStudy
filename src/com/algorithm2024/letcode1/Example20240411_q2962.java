package com.algorithm2024.letcode1;

import java.util.Arrays;

public class Example20240411_q2962 {
    public static long countSubarrays(int[] nums, int k) {
        long answer = 0;

        int max = Arrays.stream(nums)
                .max()
                .getAsInt();

        int left = 0;
        int maxCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) {
                maxCount++;
            }

            while (true) {
                if (k != maxCount) {
                    break;
                }

                if (nums[left] == max) {
                    maxCount--;
                }

                left++;
            }

            answer += left;
        }

        return answer;
    }
}
