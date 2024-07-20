package com.algorithm2024.letcode4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Example20240720_q1380 {

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        HashSet<Integer> minSet = new HashSet<>();
        HashSet<Integer> maxSet = new HashSet<>();

        for (int[] m : matrix) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < matrix[0].length; j++) {
                min = Math.min(min, m[j]);
            }

            minSet.add(min);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            int max = Integer.MIN_VALUE;

            for (int[] m : matrix) {
                max = Math.max(max, m[i]);
            }

            maxSet.add(max);
        }

        for (int i : minSet) {
            if (maxSet.contains(i)) {
                answer.add(i);
            }
        }

        return answer;
    }

}
