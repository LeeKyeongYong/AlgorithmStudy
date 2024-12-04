package com.algorithm2024.programers07;

public class Example20241204_q1 {
    static final int MOD = 1000000007;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static class MatrixCalculator {
        public static int[][] multiply(int[][] A, int[][] B, int L) {
            int[][] result = new int[L][L];
            for (int y = 0; y < L; y++) {
                for (int x = 0; x < L; x++) {
                    for (int i = 0; i < L; i++) {
                        result[y][x] = (result[y][x] + (int)(((long)A[y][i] * B[i][x]) % MOD)) % MOD;
                    }
                }
            }
            return result;
        }

        public static int[][] cal(int[][] A, int N, int L) {
            if (N == 1) {
                return A;
            }
            int[][] C1 = cal(A, N / 2, L);
            int[][] C2 = multiply(C1, C1, L);
            return N % 2 == 0 ? C2 : multiply(C2, A, L);
        }
    }

    // PathFinder: DP 배열을 관리하고, 경로 탐색을 담당
    static class PathFinder {
        private int N, M, L;
        private int[][] grid;
        private int[][][] DP;

        public PathFinder(int[][] grid, int DLength) {
            this.grid = grid;
            this.N = grid.length;
            this.M = grid[0].length;
            this.L = N * M;
            this.DP = new int[DLength + 1][L][L];

            for (int i = 0; i < L; i++) {
                DP[0][i][i] = 1;
            }
        }

        public void findPaths(int[] D) {
            for (int d = 0; d < D.length; d++) {
                for (int y = 0; y < N; y++) {
                    for (int x = 0; x < M; x++) {
                        for (int i = 0; i < 4; i++) {
                            int y1 = y + dy[i];
                            int x1 = x + dx[i];
                            if (0 <= y1 && y1 < N && 0 <= x1 && x1 < M && grid[y1][x1] - grid[y][x] == D[d]) {
                                int u = y * M + x;
                                int v = y1 * M + x1;
                                for (int l = 0; l < L; l++) {
                                    DP[d + 1][l][v] = (DP[d + 1][l][v] + DP[d][l][u]) % MOD;
                                }
                            }
                        }
                    }
                }
            }
        }

        public int[][] getFinalMatrix(int[] D, int k) {
            return MatrixCalculator.cal(DP[D.length], k, L);
        }
    }

    public static int Example20241204_q1(int[][] grid, int[] D, int k) {

        PathFinder pathFinder = new PathFinder(grid, D.length);
        pathFinder.findPaths(D);

        int[][] finalMatrix = pathFinder.getFinalMatrix(D, k);

        long sum = 0;
        for (int[] row : finalMatrix) {
            for (int value : row) {
                sum = (sum + value) % MOD;
            }
        }
        return (int) sum;
    }
}
