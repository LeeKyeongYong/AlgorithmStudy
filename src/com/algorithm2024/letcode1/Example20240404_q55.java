package com.algorithm2024.letcode1;

public class Example20240404_q55 {
    /**
     * 완탐 실패
     */

    static boolean answer;

    public static boolean canJump(int[] nums) {
        answer = false;
        dfs(0, nums);
        return answer;
    }

    static void dfs(int index, int[] nums) {
        if (index >= nums.length - 1) {
            answer = true;
            return;
        }

        for (int i = 1; i <= nums[index]; i++) {
            dfs(index + i, nums);
        }
    }

    public static void main(String[] args) {
        // false;
//        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));

        // true
        System.out.println(canJump(new int[]{2, 0}));
    }
}
