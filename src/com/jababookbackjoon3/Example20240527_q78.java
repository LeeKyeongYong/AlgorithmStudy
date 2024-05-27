package com.jababookbackjoon3;

import java.util.ArrayList;
import java.util.List;

public class Example20240527_q78 {
    static List<List<Integer>> answer;

    public static List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        permutation(0, 0, nums, new ArrayList<>());
        return answer;
    }

    static void permutation(int index, int start, int[] nums, List<Integer> now) {
        answer.add(new ArrayList<>(now));

        for (int i = start; i < nums.length; i++) {
            now.add(nums[i]);
            permutation(index + 1, i + 1, nums, now);
            now.remove(now.size() - 1);
        }
    }

    public static void main(String[] args) {
        // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
