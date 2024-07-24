package com.algorithm2024.letcode4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Example20240723_q1646 { //키/밸류 정렬 문제 2중 정렬
    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((o1, o2) -> {
            // 빈도가 작은 순서대로
            // 만약 빈도가 같다면 큰 수부터
            if (map.get(o1) == map.get(o2)) {
                return o2 - o1;
            }

            return map.get(o1) - map.get(o2);
        });

        List<Integer> answer = new ArrayList<>();
        for (Integer key : keys) {
            for (int i = 0; i < map.get(key); i++) {
                answer.add(key);
            }
        }

        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 3, 2};

        // 1,3,3,2,2
        System.out.println(Arrays.toString(frequencySort(nums)));

        // 3,1,1,2,2,2
        System.out.println(Arrays.toString(frequencySort(new int[]{1, 1, 2, 2, 2, 3})));
    }
}
