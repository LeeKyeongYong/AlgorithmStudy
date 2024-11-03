package com.algorithm2024.programers07;

public class Example202411093_q2684 {

    static int[][] pos = {{-1, 1}, {0, 1}, {1, 1}};

    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int col = 1; col < m; col++) {
            for (int row = 0; row < n; row++) {
                for (int[] p : pos) {
                    int br = row + p[0];
                    int bc = col - 1;

                    if (br >= 0 && br < n) {
                        if (grid[br][bc] < grid[row][col] && dp[br][bc] > 0) {
                            dp[row][col] = Math.max(dp[row][col], dp[br][bc] + 1);
                        }
                    }
                }
            }
        }

        int maxMoves = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxMoves = Math.max(maxMoves, dp[i][j] - 1);
            }
        }

        return maxMoves;
    }

    public static void main(String[] args) {
        Example202411093_q2684 sol = new Example202411093_q2684();

        // 3
        System.out.println(sol.maxMoves(
                new int[][]{
                        {2, 4, 3, 5},
                        {5, 4, 9, 3},
                        {3, 4, 2, 11},
                        {10, 9, 13, 15}
                }
        ));

        // 0
        System.out.println(sol.maxMoves(
                new int[][]{
                        {3, 2, 4},
                        {2, 1, 9},
                        {1, 1, 7}
                }
        ));
    }

}
