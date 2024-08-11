package com.algorithm2024.letcode5;

public class Example20240811_q840 {
    public int numMagicSquaresInside(int[][] grid) {
        int answer = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int row = 0; row + 2 < n; row++) {
            for (int col = 0; col + 2 < m; col++) {
                if (isMagicSquare(grid, row, col)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {
        boolean[] visited = new boolean[10];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[row + i][col + j];

                if (num < 1 || num > 9) {
                    return false;
                }

                if (visited[num]) {
                    return false;
                }

                visited[num] = true;
            }
        }

        int rightDown = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int rightUp = grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2];
        if (rightDown != rightUp) {
            return false;
        }

        int row1 = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        int row2 = grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2];
        int row3 = grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2];

        if (!(row1 == rightDown && row2 == rightDown && row3 == rightDown)) {
            return false;
        }

        int col1 = grid[row][col] + grid[row + 1][col] + grid[row + 2][col];
        int col2 = grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1];
        int col3 = grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2];

        return col1 == rightDown &&
                col2 == rightDown &&
                col3 == rightUp;
    }
}
