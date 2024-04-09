package com.algorithm2024.letcode1;

import java.util.HashMap;

public class Example20240409_q287 {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                return i;
            }

            map.put(i, 1);
        }

        return -1;
    }
}
