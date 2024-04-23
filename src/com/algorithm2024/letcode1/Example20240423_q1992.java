package com.algorithm2024.letcode1;

import java.util.*;

public class Example20240423_q1992 {
    static int n;
    static int m;
    static int[][] pos = {{0, 1}, {1, 0}};
    static boolean[][] visited;
    static List<int[]> answer;

    public static int[][] findFarmland(int[][] land) {
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    int[] endPoint = bfs(i, j, land);
                    answer.add(new int[]{i, j, endPoint[0], endPoint[1]});
                }
            }
        }

        int[][] ans = new int[answer.size()][4];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }

        return ans;
    }

    static int[] bfs(int row, int col, int[][] land) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});

        int fr = 0;
        int fc = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            fr = Math.max(fr, now[0]);
            fc = Math.max(fc, now[1]);

            for (int[] p : pos) {
                int nr = now[0] + p[0];
                int nc = now[1] + p[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && land[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return new int[]{fr, fc};
    }

    public static void main(String[] args) {
        int[][] lan = {{1, 0, 0}, {0, 1, 1}, {0, 1, 1}};

        // 0,0,0,0 / 1,1,2,2
        System.out.println(Arrays.deepToString(findFarmland(lan)));
    }
}
