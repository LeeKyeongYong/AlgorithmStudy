package com.algorithm2025.backjoon2.day003;

import java.util.Arrays;

public class Example20250304_Q389480 { // 코딩테스트 연습 2025 프로그래머스 코드챌린지 2차 예선  완전범죄
    public int solution(int[][] info, int n, int m) {
        int len = info.length;
        // dp[i][a]: i번째 물건까지 처리했을 때 A의 흔적이 a일 때 B의 최소 흔적
        long[][] dp = new long[len + 1][121]; // A의 최대 흔적은 40*3=120

        // 초기화: -1은 도달 불가능한 상태
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0; // 물건을 하나도 처리하지 않은 상태

        // DP 계산
        for (int i = 1; i <= len; i++) {
            int traceA = info[i - 1][0]; // A도둑이 i번째 물건을 훔칠 때 흔적
            int traceB = info[i - 1][1]; // B도둑이 i번째 물건을 훔칠 때 흔적

            for (int a = 0; a <= 120; a++) {
                // 이전 상태에서 A의 흔적이 a였던 경우
                if (dp[i - 1][a] == -1) continue;

                // 1. A도둑이 i번째 물건을 훔치는 경우
                int newTraceA = a + traceA;
                if (newTraceA <= 120) {
                    if (dp[i][newTraceA] == -1 || dp[i][newTraceA] > dp[i - 1][a]) {
                        dp[i][newTraceA] = dp[i - 1][a];
                    }
                }

                // 2. B도둑이 i번째 물건을 훔치는 경우
                long newTraceB = dp[i - 1][a] + traceB;
                if (dp[i][a] == -1 || dp[i][a] > newTraceB) {
                    dp[i][a] = newTraceB;
                }
            }
        }

        // 결과 계산: A의 흔적이 n 미만이면서 B의 흔적이 m 미만인 최소 A 흔적 찾기
        int result = -1;
        for (int a = 0; a < n; a++) {
            if (dp[len][a] != -1 && dp[len][a] < m) {
                result = a;
                break;
            }
        }

        return result;
    }
}
