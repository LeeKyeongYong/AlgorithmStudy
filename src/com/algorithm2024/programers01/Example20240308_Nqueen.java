package com.algorithm2024.programers01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Example20240308_Nqueen {
    static int[][] map;
    static int answer;
    static boolean[][] visited;
    static Set<String> set;

    public int solution(int n) {
        answer = 0;
        map = new int[n][n];
        visited = new boolean[n][n];
        set = new HashSet<String>();

        permutation(0, n, map.clone());

        return set.size();
    }

    static void permutation(int index, int n, int[][] copyMap) {
        if (index == n) {
            if (canAnswer(copyMap)) {
                set.add(Arrays.deepToString(copyMap));
                answer++;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    continue;
                }

                visited[i][j] = true;
                copyMap[i][j] = 1;
                permutation(index + 1, n, copyMap);
                copyMap[i][j] = 0;
                visited[i][j] = false;
            }
        }
    }

    static boolean canAnswer(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 1 && canAttack(i, j, map)) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean canAttack(final int row, final int col, int[][] map) {
        int n = map.length;

        // 상하 공격
        for (int i = 0; i < n; i++) {
            if (map[i][col] == 1 && row != i) {
                return true;
            }
        }

        // 좌우 공격
        for (int i = 0; i < n; i++) {
            if (map[row][i] == 1 && col != i) {
                return true;
            }
        }

        // 좌하 -> 우상 공격
        int nr = row;
        int nc = col;
        while (true) {
            nr--;
            nc++;

            if (!(nr >= 0 && nr < n && nc >= 0 && nc < n)) {
                break;
            }

            if (map[nr][nc] == 1) {
                return true;
            }
        }

        nr = row;
        nc = col;
        while (true) {
            nr++;
            nc--;

            if (!(nr >= 0 && nr < n && nc >= 0 && nc < n)) {
                break;
            }

            if (map[nr][nc] == 1) {
                return true;
            }
        }
        // 좌상 -> 우하 공격
        nr = row;
        nc = col;
        while (true) {
            nr--;
            nc--;

            if (!(nr >= 0 && nr < n && nc >= 0 && nc < n)) {
                break;
            }

            if (map[nr][nc] == 1) {
                return true;
            }
        }

        nr = row;
        nc = col;
        while (true) {
            nr++;
            nc++;

            if (!(nr >= 0 && nr < n && nc >= 0 && nc < n)) {
                break;
            }

            if (map[nr][nc] == 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Example20240308_Nqueen sol = new Example20240308_Nqueen();

        // 2
        System.out.println(sol.solution(4));
    }
}
