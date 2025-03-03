package com.algorithm2023.jababookbackjoon3;

import java.util.Scanner;

public class Example20240402_q14500 {
    static int n;
    static int m;
    static int answer;
    static int[][] map;
    static boolean[][] visited;
    static int[][] pos = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    static int[][] specialPosRow = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
    static int[][] specialPosCol = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        answer = Integer.MIN_VALUE;
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(1, i, j, map[i][j]);
                visited[i][j] = false;
                checkSpecial(i, j);
            }
        }

        System.out.println(answer);
    }

    static void checkSpecial(int row, int col) {
        for (int i = 0; i < 4; i++) {
            int temp = 0;

            for (int j = 0; j < 4; j++) {
                int nr = row + specialPosRow[i][j];
                int nc = col + specialPosCol[i][j];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m)) {
                    continue;
                }

                temp += map[nr][nc];
            }

            answer = Math.max(answer, temp);
        }
    }

    static void dfs(int index, int row, int col, int sum) {
        if (index == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (!(nr >= 0 && nr < n && nc >= 0 && nc < m) || visited[nr][nc]) {
                continue;
            }

            visited[nr][nc] = true;
            dfs(index + 1, nr, nc, sum + map[nr][nc]);
            visited[nr][nc] = false;
        }
    }
}
