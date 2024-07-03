package com.algorithm2024.programers04;

public class Example20240703_04 { //등굣길

    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        int[][] dp = new int[n + 1][m + 1];

        // 시작 위치
        dp[1][1] = 1;

        // 웅덩이 위치를 표시하기 위해 puddles 배열을 조정
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        for (int[] puddle : puddles) {
            isPuddle[puddle[1]][puddle[0]] = true;
        }

        // DP를 사용하여 경로 계산
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;
                if (isPuddle[i][j]) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                }
            }
        }

        return dp[n][m];
    }

}
