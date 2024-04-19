package com.jababookbackjoon3;

import java.util.LinkedList;
import java.util.Queue;

public class Example20240419_q2573 {
    static int n;
    static int m;
    static int[][] map;
    static int[][] pos = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static int count;
    static boolean isIslandTwice;
    static int time;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];
        isIslandTwice = false;
        time = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int index = 0;
        while (true) {
            time++;

            // 1. 녹이기
            int[][] prefix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) {
                        melt(i, j, prefix);
                    }
                }
            }

            // 2. 녹인거 반영하기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] += prefix[i][j];
                    if (map[i][j] <= 0) {
                        map[i][j] = 0;
                    }
                }
            }

            // 2. 섬 2개인지 체크하기
            visited = new boolean[n][m];
            count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && map[i][j] >= 1) {
                        checkIsland(i, j);
                    }
                }
            }

            if (count == 0 || count >= 2) {
                if (count >= 2) {
                    isIslandTwice = true;
                }

                break;
            }
        }

        if (isIslandTwice) {
            System.out.println(time);
        } else {
            System.out.println(0);
        }
    }

    static void melt(int row, int col, int[][] prefix) {
        int[] now = {row, col};

        for (int[] p : pos) {
            int nr = now[0] + p[0];
            int nc = now[1] + p[1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] >= 1) {
                prefix[nr][nc] -= 1;
            }
        }
    }

    static void checkIsland(int row, int col) {
        visited[row][col] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int[] p : pos) {
                int nr = now[0] + p[0];
                int nc = now[1] + p[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] >= 1) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        count++;
    }
}
