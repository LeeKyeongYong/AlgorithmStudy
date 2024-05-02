package com.algorithm2024.letcode2;

import java.util.Arrays;
import java.util.HashMap;

public class Example20240502_01 {
    public static int findMaxK(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        Arrays.sort(nums);
        int answer = Integer.MIN_VALUE;

        for (int i : nums) {
            int key = Math.abs(i);

            if (!map.containsKey(key)) {
                map.put(key, i);
            } else {
                Integer findValue = map.get(key);
                if (findValue == i) {
                    continue;
                }

                map.remove(key);
                answer = Math.max(answer, key);
            }
        }

        if (answer == Integer.MIN_VALUE) {
            return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        // -1
        System.out.println(findMaxK(new int[]{-9, -43, 24, -23, -16, -30, -38, -30}));
    }
}
