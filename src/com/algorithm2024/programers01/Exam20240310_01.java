package com.algorithm2024.programers01;

public class Exam20240310_01 { //프로그래머스 땅따먹기

    public static int solution(int[][] land) {
        int answer = 0;

        int row = land.length;
        int col = land[0].length;

        int[][] dp = new int[row][col];
        for (int i = 0; i < col; i++) {
            dp[0][i] = land[0][i];
        }

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
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};

        // 16
        System.out.println(solution(land));
    }

}
