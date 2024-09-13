package com.algorithm2024.letcode6;

public class Example20240913_q1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < answer.length; i++) {
            int xorResult = 0;
            int start = queries[i][0];
            int end = queries[i][1];

            for (int j = start; j <= end; j++) {
                xorResult ^= arr[j];
            }

            answer[i] = xorResult;
        }

        return answer;
    }
}
