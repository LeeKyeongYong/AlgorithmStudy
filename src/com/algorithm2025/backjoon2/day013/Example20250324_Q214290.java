package com.algorithm2025.backjoon2.day013;

public class Example20250324_Q214290 { //코딩테스트 연습 2023 현대모비스 알고리즘 경진대회 예선 경사로의 개수
    static final int MOD = 1000000007;
    static final int[] dy = {1, -1, 0, 0};
    static final int[] dx = {0, 0, 1, -1};

    // 두 행렬 A와 B를 곱하는 함수 (차원 L x L)
    public static int[][] multiply(int[][] A, int[][] B, int L) {
        int[][] result = new int[L][L];
        for (int i = 0; i < L; i++) {
            for (int k = 0; k < L; k++) {
                if (A[i][k] != 0) { // A[i][k]가 0인 경우는 건너뛰기
                    for (int j = 0; j < L; j++) {
                        result[i][j] = (int)((result[i][j] + (long)A[i][k] * B[k][j]) % MOD);
                    }
                }
            }
        }
        return result;
    }

    // 거듭제곱: A^exp를 빠르게 계산 (행렬 A의 크기는 L x L)
    public static int[][] matrixPower(int[][] A, int exp, int L) {
        int[][] result = identityMatrix(L);
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = multiply(result, A, L);
            }
            A = multiply(A, A, L);
            exp >>= 1;
        }
        return result;
    }

    // L x L 크기의 단위 행렬 생성
    public static int[][] identityMatrix(int L) {
        int[][] id = new int[L][L];
        for (int i = 0; i < L; i++) {
            id[i][i] = 1;
        }
        return id;
    }

    // grid와 주어진 차이(diff)를 바탕으로 한 이동 전이 행렬 생성
    public static int[][] buildTransitionMatrix(int[][] grid, int diff, int N, int M) {
        int L = N * M;
        int[][] mat = new int[L][L];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                int u = y * M + x;
                for (int dir = 0; dir < 4; dir++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];
                    if (ny >= 0 && ny < N && nx >= 0 && nx < M && grid[ny][nx] - grid[y][x] == diff) {
                        int v = ny * M + nx;
                        mat[u][v] = (mat[u][v] + 1) % MOD;
                    }
                }
            }
        }
        return mat;
    }

    // 전체 문제의 해법을 구하는 함수
    public static int Example20250324_Q214290(int[][] grid, int[] D, int k) {
        int N = grid.length;
        int M = grid[0].length;
        int L = N * M;

        // D 배열의 각 이동에 해당하는 전이 행렬을 순차적으로 곱하여 전체 전이 행렬 T를 구함
        int[][] T = identityMatrix(L);
        for (int d = 0; d < D.length; d++) {
            int[][] trans = buildTransitionMatrix(grid, D[d], N, M);
            T = multiply(T, trans, L);
        }

        // 전체 전이 행렬 T를 k번 거듭제곱하여 최종 상태 행렬을 구함
        int[][] finalMatrix = matrixPower(T, k, L);

        // 최종 행렬의 모든 원소의 합을 결과로 반환
        long sum = 0;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                sum = (sum + finalMatrix[i][j]) % MOD;
            }
        }
        return (int) sum;
    }
}
