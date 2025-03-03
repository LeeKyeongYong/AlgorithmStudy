package com.algorithm2023.jababookbackjoon3;

import java.util.*;

public class Example20240405_q17086 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dp;
    static List<int[]> sharks;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        dp = new int[n][m];
        map = new int[n][m];
        visited = new boolean[n][m];
        sharks = new ArrayList<>();

        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 1) {
                    sharks.add(new int[]{i, j});
                }
            }
        }

        for (int[] shark : sharks) {
            visited = new boolean[n][m];
            bfs(shark[0], shark[1]);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }

    static void bfs(int row, int col) {
        visited[row][col] = true;
        dp[row][col] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc])) {
                    continue;
                }

                dp[nr][nc] = Math.min(dp[nr][nc], dp[now[0]][now[1]] + 1);
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }
}
