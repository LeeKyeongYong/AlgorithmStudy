package com.algorithm2024.letcode4;

public class Example20240721_q1605 { //그리디 2차원 배열


    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] answer = new int[n][m];

        int[] rowSumArr = new int[n];
        int[] colSumArr = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 합 - 현재 row VS 합 - 현재 col 의 최솟값
                answer[i][j] = Math.min(rowSum[i] - rowSumArr[i], colSum[j] - colSumArr[j]);

                rowSumArr[i] += answer[i][j];
                colSumArr[j] += answer[i][j];
            }
        }
        return answer;
    }

}
