package com.algorithm2024.letcode;

import java.util.HashMap;

public class Example20240317_q2540 {
    public int getCommon(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums1) {
            map.put(i, 1);
        }

        for(int i : nums2) {
            if(map.containsKey(i)) {
                return i;
            }
        }

        return -1;
    }
}
