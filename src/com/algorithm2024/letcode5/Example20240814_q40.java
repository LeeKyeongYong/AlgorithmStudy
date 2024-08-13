package com.algorithm2024.letcode5;

import java.util.*;

public class Example20240814_q40 {

    static Set<List<Integer>> answer;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        answer = new LinkedHashSet<>();

        Arrays.sort(candidates);

        permutation(0, candidates, target, new ArrayList<>(), 0);
        return new ArrayList<>(answer);
    }

    public void permutation(int start, int[] candidates, int target, List<Integer> now, int sum) {
        if (sum == target) {
            answer.add(new ArrayList<>(now));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            sum += candidates[i];
            now.add(candidates[i]);
            permutation(i + 1, candidates, target, now, sum);
            now.remove(now.size() - 1);
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        Example20240814_q40 sol = new Example20240814_q40();

        System.out.println(
                sol.combinationSum2(
                        new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        30
                )
        );
    }

}
