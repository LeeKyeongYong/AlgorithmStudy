package com.algorithm2024.letcode1;

import java.util.HashMap;

public class Example20240410_q2958 {
    public static int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int answer = 0;

        for (int r = 0; r < nums.length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while (map.get(nums[r]) > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                l++;
            }

            answer = Math.max(answer, r - l + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));
    }
}
