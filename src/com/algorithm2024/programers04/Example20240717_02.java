package com.algorithm2024.programers04;

import java.util.LinkedList;
import java.util.Queue;

public class Example20240717_02 { // 리코쳇 로봇

    static int n, m;
    static char[][] map;
    static int[] start, dest;
    static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][] visited;

    static class Node {
        int row, col, val;

        Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int solution(String[] board) {
        initialize(board);

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.row == dest[0] && current.col == dest[1]) {
                return current.val;
            }

            for (int[] direction : directions) {
                int newRow = current.row;
                int newCol = current.col;

                while (isValid(newRow + direction[0], newCol + direction[1]) && map[newRow + direction[0]][newCol + direction[1]] != 'D') {
                    newRow += direction[0];
                    newCol += direction[1];
                }

                if (!visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.add(new Node(newRow, newCol, current.val + 1));
                }
            }
        }
        return -1;
    }

    private void initialize(String[] board) {
        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];
        start = new int[2];
        dest = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'R') {
                    start = new int[]{i, j};
                } else if (map[i][j] == 'G') {
                    dest = new int[]{i, j};
                }
            }
        }
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public static void main(String[] args) {
        Example20240717_02 sol = new Example20240717_02();
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(sol.solution(board));
    }
}
