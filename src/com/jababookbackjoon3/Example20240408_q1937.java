package com.jababookbackjoon3;

import java.util.Scanner;

public class Example20240408_q1937 {
    static int n;
    static int[][] map;
    static int answer;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        answer = 0;
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }

        System.out.println(answer);
    }

    static int dfs(int row, int col) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        dp[row][col] = 1;

        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                if (map[row][col] < map[nr][nc]) {
                    dp[row][col] = Math.max(dp[row][col], dfs(nr, nc) + 1);
                }
            }
        }

        return dp[row][col];
    }
}
