package com.algorithm2024.letcode;

import java.util.HashMap;

public class Example20240328_q930 {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefix = 0;
        for (int num : nums) {
            prefix += num;
            answer += map.getOrDefault(prefix - goal, 0);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        // 3
        System.out.println(numSubarraysWithSum(new int[]{1, 2, 2, 1, 2}, 5));
    }
}
