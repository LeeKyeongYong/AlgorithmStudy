package com.algorithm2024.programers06;

public class Example20240929_01 {

    int solution(int[][] land) {
        int answer = 0;

        int row = land.length;
        int col = land[0].length;

        int[][] dp = new int[row][col];
        System.arraycopy(land[0], 0, dp[0], 0, col);

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int max = 0;

                for (int k = 0; k < col; k++) {
                    if (j == k) {
                        continue;
                    }
                    max = Math.max(max, dp[i - 1][k]);
                }

                dp[i][j] = land[i][j] + max;
            }
        }

        for (int i = 0; i < col; i++) {
            answer = Math.max(answer, dp[row - 1][i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Example20240929_01 sol = new Example20240929_01();

        // 16
        System.out.println(sol.solution(
                new int[][]{
                        {1, 2, 3, 5},
                        {5, 6, 7, 8},
                        {4, 3, 2, 1}
                }
        ));
    }

}
