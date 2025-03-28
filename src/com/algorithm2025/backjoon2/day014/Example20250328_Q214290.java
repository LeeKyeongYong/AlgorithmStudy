package com.algorithm2025.backjoon2.day014;

public class Example20250328_Q214290 {  //2023 현대모비스 알고리즘 경진대회 예선 경사로의 개수
    static final int MOD = 1000000007;
    static final int[] dy = {1, -1, 0, 0};
    static final int[] dx = {0, 0, 1, -1};

    public static int[][] multiply(int[][] A, int[][] B, int L) {
        int[][] result = new int[L][L];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                long sum = 0;
                for (int k = 0; k < L; k++) {
                    sum = (sum + (long) A[i][k] * B[k][j]) % MOD;
                }
                result[i][j] = (int) sum;
            }
        }
        return result;
    }

    public static int[][] matrixExponentiation(int[][] A, int N, int L) {
        int[][] result = new int[L][L];
        for (int i = 0; i < L; i++) result[i][i] = 1; // 단위 행렬

        while (N > 0) {
            if ((N & 1) == 1) result = multiply(result, A, L);
            A = multiply(A, A, L);
            N >>= 1;
        }
        return result;
    }

    public static int Example20250328_Q214290(int[][] grid, int[] D, int k) {
        int N = grid.length;
        int M = grid[0].length;
        int L = N * M;

        int[][] transitionMatrix = new int[L][L];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                int u = y * M + x;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i], nx = x + dx[i];
                    if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                        int v = ny * M + nx;
                        for (int d : D) {
                            if (grid[ny][nx] - grid[y][x] == d) {
                                transitionMatrix[u][v] = (transitionMatrix[u][v] + 1) % MOD;
                            }
                        }
                    }
                }
            }
        }

        int[][] finalMatrix = matrixExponentiation(transitionMatrix, k, L);
        long sum = 0;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                sum = (sum + finalMatrix[i][j]) % MOD;
            }
        }
        return (int) sum;
    }
}
