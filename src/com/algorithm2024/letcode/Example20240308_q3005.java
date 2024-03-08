package com.algorithm2024.letcode;

import java.util.HashMap;
import java.util.Map;

public class Example20240308_q3005 {
    public int maxFrequencyElements(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }

        int answer = 0;
        for (int num : nums) {
            if (map.get(num) == max) {
                answer++;
            }
        }

        return answer;
    }
}
