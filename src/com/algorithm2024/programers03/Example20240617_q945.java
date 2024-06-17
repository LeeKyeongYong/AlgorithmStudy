package com.algorithm2024.programers03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Example20240617_q945 {

    public static int minIncrementForUnique(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];

            if (!map.containsKey(key)) {
                map.put(key, key + 1);
                continue;
            }

            // 키가 존재한다면 다음 공간이 없을때까지 갱신해준다.
            // 다음 공간이 없다면 공간을 채워두고 키값을 반환한다
            while (map.containsKey(key)) {
                key = map.get(key);
            }
            map.put(key, key + 1);
            answer += Math.abs(key - nums[i]);
        }

        return answer;
    }

    public static int minIncrementForUnique2(int[] nums) {
        int count = 0;
        int answer = 0;
        Arrays.sort(nums);

        for (int n : nums) {
            count = Math.max(count, n);
            answer += count - n;
            count++;
        }

        return answer;
    }

    public static void main(String[] args) {
        // 6
        System.out.println(minIncrementForUnique2(new int[]{3, 2, 1, 2, 1, 7}));

        // 1
        System.out.println(minIncrementForUnique(new int[]{1, 2, 2}));
    }

}
