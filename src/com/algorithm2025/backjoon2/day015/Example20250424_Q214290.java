package com.algorithm2025.backjoon2.day015;

public class Example20250424_Q214290 { //2023 현대모비스 알고리즘 경진대회 예선 경사로의 개수

    static final int MOD = 1000000007;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

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

    public static int Example20250424_Q214290(int[][] grid, int[] D, int k) {
        int N = grid.length;
        int M = grid[0].length;
        int L = N * M;

        int[][][] DP = new int[D.length + 1][L][L];
        for (int i = 0; i < L; i++) {
            DP[0][i][i] = 1;
        }

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

        int[][] finalMatrix = cal(DP[D.length], k, L);
        long sum = 0;
        for (int[] row : finalMatrix) {
            for (int value : row) {
                sum = (sum + value) % MOD;
            }
        }
        return (int) sum;
    }

}
