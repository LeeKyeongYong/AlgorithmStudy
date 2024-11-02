package com.algorithm2024.programers07;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Example20241102_q2501 {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int answer = -1;
        for (int num : nums) {
            if (set.contains(num)) {
                int length = 0;
                long current = num;

                while (set.contains((int) current)) {
                    length++;
                    set.remove((int) current);
                    current = current * current;
                }

                if (length >= 2) {
                    answer = Math.max(answer, length);
                }
            }
        }

        return answer;
    }
}
