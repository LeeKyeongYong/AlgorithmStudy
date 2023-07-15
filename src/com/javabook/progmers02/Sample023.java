package com.javabook.progmers02;

import java.util.Arrays;

public class Sample023 { // 폭탄 터뜨리기
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,0,0,0},
		                 {0,0,0,0,0},{0,0,1,0,0},{0,0,0,0,0}};
		Solution23 s = new Solution23();
		int result = s.solution(board);
		System.out.println("폭탄 터뜨리기 결과: " + result);
	}
}

class Solution23 {
	public int solution(int[][] board) {
		int answer = 0;
		int boomException = 1;
		int[][] copyBoard = new int[board.length][board[0].length];

		int index = 0;
		for (int[] tempRow : board) {
			copyBoard[index] = Arrays.copyOf(tempRow, board[index].length);
			index++;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int result = board[i][j];

				if (result == 0) {
					continue;
				}

				createBoard(i, j, boomException, copyBoard);
			}
		}

		for (int[] hits : copyBoard) {
			for (int ant : hits) {
				if (ant == 0) {
					answer++;
				}
			}
		}

		return answer;
	}

	private void createBoard(int rows, int cols, int boomException, int[][] copyBoard) {
		for (int i = rows - boomException; i <= rows + boomException; i++) {
			if (i < 0 || i >= copyBoard.length) {
				continue;
			}

			for (int cnt = cols - boomException; cnt <= cols + boomException; cnt++) {
				if (cnt < 0 || cnt >= copyBoard[0].length) {
					continue;
				}

				copyBoard[i][cnt] = 1;
			}
		}
	}
}