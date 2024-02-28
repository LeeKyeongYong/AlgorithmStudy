package com.algorithm2024.letcode;

public class Exam20240228_q200 {
    static int answer;
    static int n;
    static int m;
    static boolean[][] visited;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        answer = 0;

        n = grid.length;
        m = grid[0].length;

        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j);
                    answer++;
                }
            }
        }

        return answer;
    }

    static void dfs(char[][] grid, int row, int col) {
        visited[row][col] = true;

        for (int[] i : pos) {
            int nr = row + i[0];
            int nc = col + i[1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && grid[nr][nc] == '1') {
                dfs(grid, nr, nc);
            }
        }
    }

    public static void main(String[] args) {
        Exam20240228_q200 sol = new Exam20240228_q200();

        char[][] grid = {
                {'1', '1', '1', '1', '0' },
                {'1', '1', '0', '1', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '0', '0', '0' }
        };

        System.out.println(sol.numIslands(grid));
    }
}
