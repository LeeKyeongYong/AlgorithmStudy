package com.algorithm2024.programers01;

import java.util.Arrays;

public class Example20240309_02 { //프로그래머스 숫자 변환하기
    public static int solution(int x, int y, int n) {
        int answer = 0;

        int[] dp = new int[1000001];
        Arrays.fill(dp, -1);

        dp[x] = 0;

        for (int i = x; i <= y; i++) {
            if (i != x && dp[i] == -1) {
                continue;
            }

            if (i * 2 <= y) {
                if (dp[i * 2] == -1) {
                    dp[i * 2] = dp[i] + 1;
                } else {
                    dp[i * 2] = Math.min(dp[i] + 1, dp[i * 2]);
                }
            }

            if (i * 3 <= y) {
                if (dp[i * 3] == -1) {
                    dp[i * 3] = dp[i] + 1;
                } else {
                    dp[i * 3] = Math.min(dp[i] + 1, dp[i * 3]);
                }
            }

            if (i + n <= y) {
                if (dp[i + n] == -1) {
                    dp[i + n] = dp[i] + 1;
                } else {
                    dp[i + n] = Math.min(dp[i] + 1, dp[i + n]);
                }
            }
        }

        return dp[y];
    }

    public static void main(String[] args) {
        // 2
        System.out.println(solution(10, 40, 5));
    }
}
