package com.algorithm2024.letcode2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Example20240506_q347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (o1, o2) -> {
            return map.get(o2) - map.get(o1);
        });

        // 1 2 3
        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = keys.get(i);
        }

        return answer;
    }
}
