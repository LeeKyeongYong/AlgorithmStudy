package com.algorithm2023.jababookbackjoon3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Example20240419_q2468 {
    static int n;
    static int[][] map;
    static int[][] pos = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        answer = Integer.MIN_VALUE;
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        int maxOfCeil = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                map[i][j] = num;
                maxOfCeil = Math.max(num, maxOfCeil);
            }
        }

        while (maxOfCeil != -1) {

            // 1. 비 내리기 maxOfCeil ~ 1
            int[][] copyMap = copyMap();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (copyMap[i][j] <= maxOfCeil) {
                        copyMap[i][j] = 0;
                    }
                }
            }

            // 2. 안전영역 체크
            visited = new boolean[n][n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (copyMap[i][j] >= 1 && !visited[i][j]) {
                        bfs(i, j, copyMap);
                        count++;
                    }
                }
            }

            // 3. 안전영역 비교
            answer = Math.max(answer, count);

            maxOfCeil--;
        }

        System.out.println(answer);
    }

    static void bfs(int row, int col, int[][] map) {
        visited[row][col] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int[] p : pos) {
                int nr = now[0] + p[0];
                int nc = now[1] + p[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && map[nr][nc] >= 1) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

    private static int[][] copyMap() {
        int[][] copyMap = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, copyMap[i], 0, n);
        }

        return copyMap;
    }
}
