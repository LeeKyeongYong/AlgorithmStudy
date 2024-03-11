package com.jababookbackjoon2;

import java.util.Scanner;

public class Example20240311_q17485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][m];
        int[][][] dp = new int[n][m][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();

                if (i == 0) {
                    dp[i][j][0] = map[i][j];
                    dp[i][j][1] = map[i][j];
                    dp[i][j][2] = map[i][j];
                }

                if (j == m - 1) {
                    dp[i][j][0] = Integer.MAX_VALUE;
                }

                if (j == 0) {
                    dp[i][j][2] = Integer.MAX_VALUE;
                }
            }
        }

        // 0 좌측 아래로 오는 경우
        // 1 내려오는 것
        // 2 우측 아래로 오는 경우
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 좌측 아래로 오는 경우
                if (isValidRange(i - 1, j + 1, n, m)) {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j];
                }

                // 아래로 오는 경우
                if (isValidRange(i - 1, j, n, m)) {
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + map[i][j];
                }

                // 우측 아래로 오는 경우
                if (isValidRange(i - 1, j - 1, n, m)) {
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + map[i][j];
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                answer = Math.min(dp[n - 1][i][j], answer);
            }
        }

        System.out.println(answer);
    }

    static boolean isValidRange(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}
