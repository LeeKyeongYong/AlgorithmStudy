package com.algorithm2024.letcode;

import java.util.PriorityQueue;

public class Example20240327_q994 {
    static int n;
    static int m;
    static boolean[][] visited;
    static int answer;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int orangesRotting(int[][] map) {
        n = map.length;
        m = map[0].length;
        visited = new boolean[n][m];
        answer = 0;

        if (isClear(map)) {
            return 0;
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        int time = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    q.add(new int[]{i, j, time});
                    visited[i][j] = true;
                }
            }
        }

        boolean isNormal = false;
        while (!q.isEmpty()) {
            if (isClear(map)) {
                isNormal = true;
                break;
            }

            int[] now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] == 1)) {
                    continue;
                }

                map[nr][nc] = 2;
                visited[nr][nc] = true;
                answer = Math.max(answer, now[2] + 1);
                q.add(new int[]{nr, nc, now[2] + 1});
            }
        }

        return isNormal ? answer : -1;
    }

    private boolean isClear(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
