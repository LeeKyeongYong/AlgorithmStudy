package com.algorithm2024.programers03;

public class Example20240512_01 { //가장큰정사각형찾기

    public static int solution(int[][] board) {

        int n = board.length;
        int m = board[0].length;

        int[][] dp = new int[n + 1][m + 1];
        int max = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i - 1][j - 1] != 0) {
                    int minOfNear = Math.min(dp[i - 1][j], dp[i][j - 1]);

                    int min = Math.min(minOfNear, dp[i - 1][j - 1]);
                    dp[i][j] = min + 1;

                    max = Math.max(max, min + 1);
                }
            }
        }

        return (int) Math.pow(max, 2);
    }

    public static int bruteForceFailVersion(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    answer = Math.max(answer, 1);
                    int index = 1;
                    int startRow = i;
                    int startCol = j;

                    while (true) {
                        int nr = startRow + index;
                        int nc = startCol + index;

                        if (!(nr >= 0 && nr < n && nc >= 0 && nc < m)) {
                            break;
                        }

                        if (board[nr][startCol] == 1 && board[nr][nc] == 1 && board[startRow][nc] == 1) {
                            index++;
                        } else {
                            break;
                        }
                    }

                    answer = (int) Math.max(answer, Math.pow(index, 2));
                }
            }
        }

        return answer;
    }
}
