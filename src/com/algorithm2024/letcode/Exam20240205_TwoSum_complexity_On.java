package com.algorithm2024.letcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Exam20240205_TwoSum_complexity_On {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (map.containsKey(target - num)) {
                Integer index = map.get(target - num);
                answer = new int[]{index, i};
            } else {
                map.put(num, i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Exam20240205_TwoSum_complexity_On s = new Exam20240205_TwoSum_complexity_On();

        // 1, 2
        System.out.println(Arrays.toString(s.twoSum(new int[]{3, 2, 4}, 6)));
    }
}
