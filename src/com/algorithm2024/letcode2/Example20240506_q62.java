package com.algorithm2024.letcode2;

public class Example20240506_q62 {

    public int uniquePaths(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i <= m; i++) {
            dp[0][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + 1;
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][m] + 1;
    }
}
