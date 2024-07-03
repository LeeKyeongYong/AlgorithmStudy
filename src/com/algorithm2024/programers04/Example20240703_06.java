package com.algorithm2024.programers04;

public class Example20240703_06 { //2022 KAKAO BLIND RECRUITMENT 파괴되지 않은 건물

    public int solution(int[][] board, int[][] skill) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] tmp = new int[rows + 1][cols + 1];

        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];

            int delta = type == 2 ? degree : -degree;

            tmp[r1][c1] += delta;
            tmp[r1][c2 + 1] -= delta;
            tmp[r2 + 1][c1] -= delta;
            tmp[r2 + 1][c2 + 1] += delta;
        }

        // 행 기준 누적합
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 1; j < cols + 1; j++) {
                tmp[i][j] += tmp[i][j - 1];
            }
        }

        // 열 기준 누적합
        for (int j = 0; j < cols + 1; j++) {
            for (int i = 1; i < rows + 1; i++) {
                tmp[i][j] += tmp[i - 1][j];
            }
        }

        int answer = 0;
        // 기존 배열과 합치기
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] += tmp[i][j];
                if (board[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }


}
