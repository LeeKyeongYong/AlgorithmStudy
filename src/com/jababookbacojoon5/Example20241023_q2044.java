package com.jababookbacojoon5;

import java.util.*;

public class Example20241023_q2044 {

    static int n;
    static Map<Integer, Integer> map;

    public int countMaxOrSubsets(int[] nums) {
        n = nums.length;
        map = new HashMap<>();

        permutation(0, 0, new ArrayList<>(), nums);

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (o1, o2) -> o2 - o1);

        return map.get(keys.get(0));
    }

    static void permutation(int index, int start, List<Integer> now, int[] nums) {
        if (index != 0) {
            int bit = 0;
            for (int i : now) {
                bit |= i;
            }
            map.put(bit, map.getOrDefault(bit, 0) + 1);
        }

        for (int i = start; i < n; i++) {
            now.add(nums[i]);
            permutation(index + 1, i + 1, now, nums);
            now.remove(now.size() - 1);
        }
    }

    public static void main(String[] args) {
        Example20241023_q2044 sol = new Example20241023_q2044();

        // 2
        System.out.println(sol.countMaxOrSubsets(new int[]{3, 1}));
    }
}
