package com.jababookbackjoon4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Example20240528_q2665 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dp;
    static int answer;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        dp = new int[n][n];

        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        answer = 0;

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        dp[0][0] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < n)) {
                    continue;
                }

                if (!(dp[nr][nc] > dp[now[0]][now[1]])) {
                    continue;
                }

                if (map[nr][nc] == 0) {
                    dp[nr][nc] = Math.min(dp[nr][nc], dp[now[0]][now[1]] + 1);
                } else {
                    dp[nr][nc] = Math.min(dp[nr][nc], dp[now[0]][now[1]]);
                }

                q.add(new int[]{nr, nc});
            }
        }

        answer = dp[n - 1][n - 1];
    }
}
