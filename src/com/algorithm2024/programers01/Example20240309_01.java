package com.algorithm2024.programers01;

import java.util.Stack;

public class Example20240309_01 {//프로그래머스 크레인형뽑기
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        int n = board.length;
        int m = board[0].length;

        for (int move : moves) {
            int column = move - 1;

            for (int i = 0; i < n; i++) {
                if (board[i][column] == 0) {
                    continue;
                }

                int copy = board[i][column];
                board[i][column] = 0;

                if (!stack.isEmpty() && stack.peek() == copy) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(copy);
                }

                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution(board, moves));
    }
}
