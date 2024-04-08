package com.jababookbackjoon3;

import java.util.Arrays;
import java.util.Scanner;

public class Example20240408_q17485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        int[][][] dp = new int[3][n][m];

        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, Integer.MAX_VALUE);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();

                if (i == 0) {
                    dp[0][i][j] = map[i][j];
                    dp[1][i][j] = map[i][j];
                    dp[2][i][j] = map[i][j];
                }
            }
        }


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isValid(i - 1, j + 1, n, m)) {
                    dp[0][i][j] = Math.min(dp[1][i - 1][j + 1], dp[2][i - 1][j + 1]) + map[i][j];
                }

                if (isValid(i - 1, j, n, m)) {
                    dp[1][i][j] = Math.min(dp[0][i - 1][j], dp[2][i - 1][j]) + map[i][j];
                }

                if (isValid(i - 1, j - 1, n, m)) {
                    dp[2][i][j] = Math.min(dp[0][i - 1][j - 1], dp[1][i - 1][j - 1]) + map[i][j];
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                answer = Math.min(dp[j][n - 1][i], answer);
            }
        }

        System.out.println(answer);
    }

    static boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}
