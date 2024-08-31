package com.algorithm2024.letcode6;

public class Example20240831_q1905 {
    static int n;
    static int m;
    static boolean[][] visited;
    static int answer;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid1.length;
        m = grid1[0].length;
        visited = new boolean[n][m];
        answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid2[i][j] == 1) {
                    if (dfs(i, j, grid1, grid2)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    static boolean dfs(int row, int col, final int[][] grid1, final int[][] grid2) {
        visited[row][col] = true;
        boolean isSubIsland = true;

        if (grid1[row][col] == 0) {
            isSubIsland = false;
        }

        for (int[] p : pos) {
            int nr = row + p[0];
            int nc = col + p[1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && grid2[nr][nc] == 1) {
                if (!dfs(nr, nc, grid1, grid2)) {
                    isSubIsland = false;
                }
            }
        }

        return isSubIsland;
    }

    public static void main(String[] args) {
        Example20240831_q1905 sol = new Example20240831_q1905();

        // 2
        System.out.println(sol.countSubIslands(
                new int[][]{{1, 0, 1, 0, 1}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {1, 0, 1, 0, 1}},
                new int[][]{{0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {0, 1, 0, 1, 0}, {0, 1, 0, 1, 0}, {1, 0, 0, 0, 1}}
        ));
    }
}
