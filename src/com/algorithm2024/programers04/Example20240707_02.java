package com.algorithm2024.programers04;

public class Example20240707_02 { //2020 KAKAO BLIND RECRUITMENT 자물쇠와 열쇠

    public boolean solution(int[][] key, int[][] lock) {
        int N = lock.length;
        int M = key.length;

        // Create an extended board to fit the key and lock
        int[][] board = new int[N + 2 * M][N + 2 * M];

        // Place the lock in the middle of the extended board
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[M + i][M + j] = lock[i][j];
            }
        }

        // Check all four rotations of the key
        for (int r = 0; r < 4; r++) {
            key = rotate(key); // Rotate the key

            // Try to fit the key into all positions on the board
            for (int i = 1; i <= N + M; i++) {
                for (int j = 1; j <= N + M; j++) {
                    if (compare(board, key, i, j, M, N)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // Check if the key fits the lock at position (x, y)
    private boolean compare(int[][] board, int[][] key, int x, int y, int M, int N) {
        // Add key to the board
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                board[x + i][y + j] += key[i][j];
            }
        }

        // Check if the lock is fully covered and no mismatches
        boolean valid = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[M + i][M + j] != 1) {
                    valid = false;
                    break;
                }
            }
            if (!valid) break;
        }

        // Remove key from the board
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                board[x + i][y + j] -= key[i][j];
            }
        }

        return valid;
    }

    // Rotate the key 90 degrees clockwise
    private int[][] rotate(int[][] key) {
        int n = key.length;
        int[][] rotatedKey = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedKey[j][n - i - 1] = key[i][j];
            }
        }
        return rotatedKey;
    }



}
