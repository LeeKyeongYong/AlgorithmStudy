package com.algorithm2023.jababookbackjoon4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Example20240818_q3055 {
    static int n, m;
    static char[][] map;
    static int[][] waterDp;
    static int[][] playerDp;
    static int[] playerStartPos;
    static Queue<int[]> waterPos;
    static int[] endPos;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][] playerVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        waterDp = new int[n][m];
        playerDp = new int[n][m];
        map = new char[n][m];
        waterPos = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                map[i][j] = c;
                if (c == 'S') {
                    playerStartPos = new int[]{i, j};
                    map[i][j] = '.';
                }
                if (c == '*') {
                    waterPos.add(new int[]{i, j});
                }
                if (c == 'D') {
                    endPos = new int[]{i, j};
                }
            }
        }

        for (int[] row : waterDp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int[] row : playerDp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        waterBfs();
        playerBfs();

        int result = playerDp[endPos[0]][endPos[1]];
        System.out.println(result == Integer.MAX_VALUE ? "KAKTUS" : result);
    }

    static void playerBfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(playerStartPos);

        playerVisited = new boolean[n][m];
        playerVisited[playerStartPos[0]][playerStartPos[1]] = true;
        playerDp[playerStartPos[0]][playerStartPos[1]] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == endPos[0] && now[1] == endPos[1]) {
                break;
            }

            for (int[] p : pos) {
                int nr = p[0] + now[0];
                int nc = p[1] + now[1];

                if (validateRange(nr, nc) && !playerVisited[nr][nc] && (map[nr][nc] == '.' || map[nr][nc] == 'D')) {
                    if (playerDp[now[0]][now[1]] + 1 < waterDp[nr][nc]) {
                        playerVisited[nr][nc] = true;
                        playerDp[nr][nc] = playerDp[now[0]][now[1]] + 1;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }

    private static boolean validateRange(final int nr, final int nc) {
        return nr >= 0 && nc >= 0 && nr < n && nc < m;
    }

    static void waterBfs() {
        boolean[][] visited = new boolean[n][m];
        for (int[] p : waterPos) {
            visited[p[0]][p[1]] = true;
            waterDp[p[0]][p[1]] = 0;
        }

        while (!waterPos.isEmpty()) {
            int[] now = waterPos.poll();

            for (int[] p : pos) {
                int nr = p[0] + now[0];
                int nc = p[1] + now[1];

                if (validateRange(nr, nc) && !visited[nr][nc] && map[nr][nc] == '.') {
                    visited[nr][nc] = true;
                    waterDp[nr][nc] = waterDp[now[0]][now[1]] + 1;
                    waterPos.add(new int[]{nr, nc});
                }
            }
        }
    }
}
