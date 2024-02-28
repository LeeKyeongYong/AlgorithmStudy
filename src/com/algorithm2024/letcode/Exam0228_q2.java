package com.algorithm2024.letcode;

public class Exam0228_q2 {
    private static int[][] map;
    private static int[][] dp;
    private static int[] dy = {1, -2};
    private static int[] dx = {1, 1};
    private static int count = 0;
    private static boolean has;
    private static int maxX;
    private static int maxY;

    public int solution(int w, int h, int[][] walls) {
        map = new int[h + 1][w + 1]; // w최대 1000
        dp = new int[h + 1][w + 1]; // w최대 1000
        maxX = w;
        maxY = h;

        // 장애물 설치
        for (int[] wall : walls) {
            int x = wall[0];
            int startY = wall[1];
            int endY = wall[2];
            for (int i = 0; i < h + 1; i++) {
                if (startY < i && i < endY) {
                    map[i][x] = 0;
                } else {
                    map[i][x] = 1;
                }
            }
        }

        int result = start(h / 2, 0);

        if (!has) {
            return -1;
        }
        return result;
    }

    private static int start(int y, int x) {
        if (dp[y][x] != 0) {
            return dp[y][x];
        }

        if (x == maxX) {
            has = true;
            return 1;
        }

        for (int i = 0; i < 2; i++) {
            int moveY = y + dy[i];
            int moveX = x + dx[i];

            if (inMap(moveY, moveX) && map[moveY][moveX] == 0) {
                dp[y][x] = (dp[y][x] + start(moveY, moveX)) % 10007;
            }
        }

        return dp[y][x];
    }

    private static boolean inMap(int y, int x) {
        return 0 < y && y < maxY && 0 <= x && x <= maxX;
    }
}
