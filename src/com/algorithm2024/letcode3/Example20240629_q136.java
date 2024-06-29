package com.algorithm2024.letcode3;

import java.util.HashMap;

public class Example20240629_q136 {

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
                return i;
            }
        }

        return -1;
    }

}
