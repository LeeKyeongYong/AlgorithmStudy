package com.algorithm2024.programers04;

import java.util.Arrays;

public class Example20240703_05 { //2017 카카오코드 예선보행자 천국

    private static final int MOD = 20170805;
    private int[][][] dp;
    private int[][] map;
    private int width, height;

    // 방향 벡터: 아래쪽, 오른쪽
    private final int[] dx = {1, 0};
    private final int[] dy = {0, 1};

    // DFS 함수: (x, y) 좌표와 방향 dir
    private int dfs(int x, int y, int dir) {
        // 범위를 벗어나면 0 반환
        if (x < 0 || y < 0 || x >= height || y >= width) return 0;

        // 이미 계산된 값이 있으면 반환
        if (dp[x][y][dir] != -1) return dp[x][y][dir];

        // 도착지점에 도달하면 1 반환
        if (x == height - 1 && y == width - 1) return 1;

        // 맵이 0일 때
        if (map[x][y] == 0) {
            dp[x][y][dir] = (dfs(x + 1, y, 0) + dfs(x, y + 1, 1)) % MOD;
        }
        // 맵이 2일 때
        else if (map[x][y] == 2) {
            dp[x][y][dir] = dfs(x + dx[dir], y + dy[dir], dir) % MOD;
        }
        // 맵이 1일 때
        else {
            dp[x][y][dir] = 0;
        }

        return dp[x][y][dir];
    }

    public int solution(int m, int n, int[][] city_map) {
        height = m;
        width = n;
        map = city_map;

        // dp 배열을 -1로 초기화
        dp = new int[501][501][2];
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        // 출발 지점에서 양방향 다 호출
        dfs(0, 0, 1);
        dfs(0, 0, 0);

        // 출발 지점 (0, 0)에서 더 큰 값 반환
        return Math.max(dp[0][0][0], dp[0][0][1]);
    }

}
