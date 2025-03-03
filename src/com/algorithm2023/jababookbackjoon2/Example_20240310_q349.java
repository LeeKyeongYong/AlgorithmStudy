package com.algorithm2023.jababookbackjoon2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example_20240310_q349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> answer = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {
            map.put(num, 1);
        }

        for (int num : nums2) {
            if (map.containsKey(num)) {
                answer.add(num);
                map.remove(num);
            }
        }

        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
