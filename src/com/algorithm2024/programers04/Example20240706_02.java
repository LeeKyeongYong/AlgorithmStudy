package com.algorithm2024.programers04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example20240706_02 { //2017 카카오코드 본선 튜브의 소개팅

    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static long[][][] dp;
    private static int M, N, S;
    private static long MAX = Integer.MAX_VALUE;
    private static int[][] map;

    // Helper function to check if coordinates are within bounds
    private static boolean inRange(int x, int y) {
        return (0 <= x && x < M && 0 <= y && y < N);
    }

    // Recursive function with memoization to find minimum talk time
    private static long solve(int x, int y, int dist) {
        if (dist < 0 || !inRange(x, y) || map[x][y] == -1) {
            return MAX;
        }
        if (x == M - 1 && y == N - 1 && dist == 0) {
            return 0;
        }
        if (dp[x][y][dist] != -1) {
            return dp[x][y][dist];
        }

        long minTalkTime = MAX;
        for (int[] direction : DIRECTIONS) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];
            if (inRange(nextX, nextY) && map[nextX][nextY] != -1) {
                long talkTime = solve(nextX, nextY, dist - 1) + map[x][y];
                if (talkTime <= S) {
                    minTalkTime = Math.min(minTalkTime, talkTime);
                }
            }
        }

        return dp[x][y][dist] = minTalkTime;
    }

    public static List<Integer> solution(int m, int n, int s, int[][] timeMap) {
        M = m;
        N = n;
        S = s;
        map = timeMap;

        // Adjust the size of dp array based on max possible distance
        dp = new long[M][N][M * N + 1];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int moveDistance = (int) MAX;
        int sumOfTalkTime = (int) MAX;

        for (int i = M + N - 2; i <= M * N; i++) {
            long ret = solve(0, 0, i);
            if (ret < MAX) {
                moveDistance = i;
                sumOfTalkTime = (int) ret;
                break;
            }
        }

        List<Integer> answer = new ArrayList<>();
        answer.add(moveDistance);
        answer.add(sumOfTalkTime);
        return answer;
    }

}
