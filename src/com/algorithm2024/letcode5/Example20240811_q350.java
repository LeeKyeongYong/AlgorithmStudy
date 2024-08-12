package com.algorithm2024.letcode5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Example20240811_q350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : nums2) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) - 1);

                if (map.get(i) == 0) {
                    map.remove(i);
                }

                list.add(i);
            }
        }

        int[] answer = new int[list.size()];

        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }

}
