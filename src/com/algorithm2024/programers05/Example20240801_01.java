package com.algorithm2024.programers05;

public class Example20240801_01 { //최적의 행렬 곱셈

    public  int solution (int[][] matrixSizes) {
        int n = matrixSizes.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i][k] + dp[k + 1][j] + matrixSizes[i][0] * matrixSizes[k + 1][0] * matrixSizes[j][1]);
                }
            }
        }

        return dp[0][n - 1];
    }

}
