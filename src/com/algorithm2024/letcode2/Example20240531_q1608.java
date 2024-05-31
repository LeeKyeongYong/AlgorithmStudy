package com.algorithm2024.letcode2;

import java.util.Arrays;

public class Example20240531_q1608 {

    public int specialArray(int[] nums) {
        int answer = -1;

        Arrays.sort(nums);
        int maxValue = nums[nums.length - 1];

        for (int i = 1; i <= maxValue; i++) {
            int count = 0;

            for (int j = 0; j < nums.length; j++) {
                if (i <= nums[j]) {
                    count++;
                }
            }

            if (count == i) {
                answer = Math.max(answer, i);
            }
        }

        return answer;
    }
}
