package com.algorithm2024.letcode2;

public class Example20240515_q26 {
    public int removeDuplicates(int[] nums) {
        int answer = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[answer] = nums[i];
                answer++;
            }
        }
        return answer;
    }
}
