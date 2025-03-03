package com.algorithm2023.jababookbackjoon3;

import java.util.*;

public class Example20240428_q14502 {
    static int n;
    static int m;
    static int[][] map;
    static int answer;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static List<int[]> walls;
    static List<int[]> viruses;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        answer = 0;
        walls = new ArrayList<>();
        viruses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0) {
                    walls.add(new int[]{i, j});
                }

                if (map[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }

        permutation(0, 0, new int[3][]);
        System.out.println(answer);
    }

    static void permutation(int index, int start, int[][] virus) {
        if (index == 3) {
            int countSafePlace = getSafePlace(virus);
            answer = Math.max(answer, countSafePlace);
            return;
        }

        for (int i = start; i < walls.size(); i++) {
            virus[index] = walls.get(i);
            permutation(index + 1, i + 1, virus);
        }
    }

    static int getSafePlace(final int[][] walls) {
        int[][] copyMap = copy();

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        // 1. 벽 세팅
        for (int[] pos : walls) {
            copyMap[pos[0]][pos[1]] = 1;
        }

        // 1-1. 바이러스 세팅
        for (int[] virus : viruses) {
            q.add(virus);
            visited[virus[0]][virus[1]] = true;
        }

        // 2. 바이러스 퍼뜨리기
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int[] p : pos) {
                int nr = now[0] + p[0];
                int nc = now[1] + p[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && copyMap[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    copyMap[nr][nc] = 2;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        // 3. 안전 영역 반환하기
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private static int[][] copy() {
        int[][] copyMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        return copyMap;
    }
}
