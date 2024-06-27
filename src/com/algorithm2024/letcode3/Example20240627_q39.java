package com.algorithm2024.letcode3;

import java.util.ArrayList;
import java.util.List;

public class Example20240627_q39 {
    static List<List<Integer>> answer;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();

        permutation(0, new ArrayList<>(), 0, target, candidates);
        return answer;
    }

    static void permutation(int index, List<Integer> list, int sum, int target, int[] candidates) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            sum += candidates[i];
            permutation(i, list, sum, target, candidates);
            sum -= candidates[i];
            list.remove(Integer.valueOf(candidates[i]));
        }
    }

    public static void main(String[] args) {
        // [2,2,3], [7]
        System.out.println(combinationSum(
                new int[]{2, 3, 6, 7},
                7
        ));
    }
}
