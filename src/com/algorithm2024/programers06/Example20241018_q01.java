package com.algorithm2024.programers06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example20241018_q01 {

    static final int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static List<Integer> areas;
    static int areaCount;
    static int[][] picture;
    static int n;
    static int m;
    static boolean[][] visited;
    static int temp;

    public int[] solution(int m, int n, int[][] picture) {
        areas = new ArrayList<>();
        areaCount = 0;
        this.picture = picture;
        n = picture.length;
        m = picture[0].length;
        this.n = n;
        this.m = m;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    temp = 0;
                    dfs(i, j, picture[i][j]);
                    areas.add(temp);
                    areaCount++;
                }
            }
        }

        Collections.sort(areas);

        return new int[]{areaCount, areas.get(areas.size() - 1)};
    }

    private void dfs(int row, int col, int color) {
        visited[row][col] = true;
        temp++;

        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && picture[nr][nc] == color && !visited[nr][nc]) {
                dfs(nr, nc, color);
            }
        }
    }

    public static void main(String[] args) {
        Example20241018_q01 sol = new Example20241018_q01();
        int[][] map = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        // 4, 5
        System.out.println(Arrays.toString(sol.solution(6, 4, map)));
    }

}
