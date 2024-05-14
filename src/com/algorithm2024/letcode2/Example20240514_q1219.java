package com.algorithm2024.letcode2;

public class Example20240514_q1219 {

    private static final int[] dir = new int[]{0, 1, 0, -1, 0};

    public static int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int max = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                max = Math.max(max, permutation(grid, rows, cols, row, col));
            }
        }
        return max;
    }

    private static int permutation(int[][] grid, int rows, int cols, int row, int col) {
        if (row < 0 || col < 0 || row == rows || col == cols || grid[row][col] == 0) {
            return 0;
        }

        int max = 0;
        int sourceValue = grid[row][col];

        grid[row][col] = 0;
        for (int direction = 0; direction < 4; direction++) {
            max = Math.max(max, permutation(grid, rows, cols, dir[direction] + row, dir[direction + 1] + col));
        }
        grid[row][col] = sourceValue;

        return max + sourceValue;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 0, 7, 0, 0, 0},
                {2, 0, 6, 0, 1, 0},
                {3, 5, 6, 7, 4, 2},
                {4, 3, 1, 0, 2, 0},
                {3, 0, 5, 0, 20, 0}
        };

        // 60
        System.out.println(getMaximumGold(arr));
    }
}
