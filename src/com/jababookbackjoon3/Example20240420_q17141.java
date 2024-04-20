package com.jababookbackjoon3;

import java.util.*;

public class Example20240420_q17141 {
    static int n;
    static int m;
    static int[][] map;
    static int answer;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static List<int[]> viruses;
    static boolean solve;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        answer = Integer.MAX_VALUE;
        viruses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }

        permutation(0, 0, new int[m][]);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    static void permutation(int index, int start, int[][] virus) {
        if (index == m) {
            solve = true;
            int countSafePlace = getTime(virus);

            if (solve) {
                answer = Math.min(answer, countSafePlace);
            }
            return;
        }

        for (int i = start; i < viruses.size(); i++) {
            virus[index] = viruses.get(i);
            permutation(index + 1, i + 1, virus);
        }
    }

    static int getTime(final int[][] virus) {
        // 1. 맵 char로 카피 벽은 W, 나머진 .
        char[][] copyMap = copy();
        Queue<int[]> q = new LinkedList<>();
        int[][] dp = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        // 2. 바이러스 지점에만 V로 체크, Queue에 저장
        for (int[] v : virus) {
            copyMap[v[0]][v[1]] = 'V';
            q.add(new int[]{v[0], v[1]});
            dp[v[0]][v[1]] = 0;
            visited[v[0]][v[1]] = true;
        }

        // 요소 하나하나로 체킹
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int[] p : pos) {
                int nr = now[0] + p[0];
                int nc = now[1] + p[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && copyMap[nr][nc] == '.') {
                    visited[nr][nc] = true;
                    copyMap[nr][nc] = 'V';
                    dp[nr][nc] = dp[now[0]][now[1]] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copyMap[i][j] == '.') {
                    solve = false;
                    break;
                }

                count = Math.max(count, dp[i][j]);
            }
        }

        return count;
    }

    private static char[][] copy() {
        char[][] copyMap = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    copyMap[i][j] = '.';
                } else if (map[i][j] == 1) {
                    copyMap[i][j] = 'W';
                } else copyMap[i][j] = '.';
            }
        }

        return copyMap;
    }
}
