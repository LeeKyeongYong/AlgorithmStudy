package com.algorithm2025.backjoon.day013;

public class Example20250223_Q181829 { // 코딩테스트 연습 코딩 기초 트레이닝 이차원 배열 대각선 순회하기

    public int solution(int[][] board, int k) {
        int sum = 0;
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i + j <= k) {
                    sum += board[i][j];
                }
            }
        }

        return sum;
    }
}
