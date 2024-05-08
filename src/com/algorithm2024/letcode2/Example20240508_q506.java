package com.algorithm2024.letcode2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Example20240508_q506 {
    public String[] findRelativeRanks(int[] score) {
        Integer[] copy = new Integer[score.length];

        for (int i = 0; i < score.length; i++) {
            copy[i] = score[i];
        }

        Arrays.sort(copy, (o1, o2) -> o2 - o1);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < copy.length; i++) {
            map.put(copy[i], i + 1);
        }

        String[] answer = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int rank = map.get(score[i]);

            if (rank == 1) {
                answer[i] = "Gold Medal";
            } else if (rank == 2) {
                answer[i] = "Silver Medal";
            } else if (rank == 3) {
                answer[i] = "Bronze Medal";
            } else {
                answer[i] = "" + rank;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Example20240508_q506 sol = new Example20240508_q506();

        System.out.println(Arrays.toString(sol.findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
    }
}
