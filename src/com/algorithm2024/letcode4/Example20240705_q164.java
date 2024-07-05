package com.algorithm2024.letcode4;

import java.util.Arrays;

public class Example20240705_q164 {
    public int maximumGap(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int gap = 0;
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > gap) {
                gap = nums[i] - nums[i - 1];
            }
        }

        return gap;
    }
}
