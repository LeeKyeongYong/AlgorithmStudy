package com.algorithm2023.jababookbackjoon3;

import java.util.Scanner;

public class Example20240403_q2146 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        visited = new boolean[n][n];
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int sign = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, map[i][j], sign);
                    sign++;
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int s = 1; s <= sign; s++) {
            int minValue = Integer.MAX_VALUE;

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (map[r][c] == s) {

                        for (int nr = 0; nr < n; nr++) {
                            for (int nc = 0; nc < n; nc++) {
                                if (map[nr][nc] > s) {
                                    int distance = Math.abs(r - nr) + Math.abs(c - nc) - 1;
                                    minValue = Math.min(distance, minValue);
                                }
                            }
                        }
                    }
                }
            }

            answer = Math.min(answer, minValue);
        }
        System.out.println(answer);
    }

    static void dfs(int row, int col, int origin, int sign) {
        visited[row][col] = true;
        map[row][col] = sign;

        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && map[nr][nc] == origin) {
                visited[nr][nc] = true;
                dfs(nr, nc, origin, sign);
            }
        }
    }
}
