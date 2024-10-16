package com.algorithm2024.programers06;

import java.util.LinkedList;
import java.util.Queue;

public class Example20241016_q2 {
    static final int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static int n;
    static int m;
    static char[][] map;
    static int[] startPos;
    static int[] leverPos;
    static int[] endPos;
    static int answer;

    public static int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        startPos = new int[2];
        leverPos = new int[2];
        endPos = new int[2];
        answer = 0;

        for (int i = 0; i < n; i++) {
            String str = maps[i];
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                map[i][j] = c;

                if (c == 'S') {
                    startPos = new int[]{i, j};
                }

                if (c == 'L') {
                    leverPos = new int[]{i, j};
                }

                if (c == 'E') {
                    endPos = new int[]{i, j};
                }
            }
        }

        int count = bfs(startPos, leverPos);
        int goal = bfs(leverPos, endPos);

        if (count == -1 || goal == -1) {
            return -1;
        }

        return count + goal;
    }

    private static int bfs(int[] startPos, int[] targetPos) {
        char[][] map = copyMap();
        boolean[][] visited = new boolean[n][m];
        visited[startPos[0]][startPos[1]] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startPos[0], startPos[1], 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == targetPos[0] && now[1] == targetPos[1]) {
                return now[2];
            }

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] != 'X') {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, now[2] + 1});
                }
            }
        }

        return -1;
    }

    private static char[][] copyMap() {
        char[][] copy = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = map[i][j];
            }
        }

        return copy;
    }
}
