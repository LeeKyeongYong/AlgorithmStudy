package com.algorithm2024.letcode;

import java.util.HashSet;
import java.util.Set;

public class Exam20240205_q217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        return set.size() != nums.length;
    }
}
