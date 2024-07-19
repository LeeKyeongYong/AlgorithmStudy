package com.algorithm2024.letcode4;

import java.util.Arrays;

public class Example20240719_q2656 { //그리디 sum 구하기

    public int maximizeSum(int[] nums, int k) {
        int answer = 0;
        int index = 0;
        Arrays.sort(nums);

        while (index < k) {
            answer += nums[nums.length - 1];
            nums[nums.length - 1] += 1;
            index++;
        }

        return answer;
    }

}
