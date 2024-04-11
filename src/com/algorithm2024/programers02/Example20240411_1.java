package com.algorithm2024.programers02;

import java.util.LinkedList;
import java.util.Queue;

public class Example20240411_1 {//경주로건설
    static int n, m;
    static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][][] visited;
    static int answer;

    static class Node {
        int row;
        int col;
        int dir;
        int value;

        public Node(final int row, final int col, final int dir, final int value) {
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.value = value;
        }
    }

    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        n = board.length;
        m = board[0].length;
        visited = new boolean[n][m][4];

        Node node = new Node(0, 0, -1, 0);
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.row == n - 1 && now.col == m - 1) {
                answer = Math.min(answer, now.value);
                continue;
            }

            for (int i = 0; i < pos.length; i++) {
                int nr = now.row + pos[i][0];
                int nc = now.col + pos[i][1];

                if (!validateRange(nr, nc, board)) {
                    continue;
                }

                int nextValue = now.value;

                // 초기이거나 같은 방향이라면
                if (now.dir == -1 || now.dir == i) {
                    nextValue += 100;
                } else {
                    nextValue += 600;
                }

                if (!visited[nr][nc][i] || board[nr][nc] >= nextValue) {
                    // 첫 방문이거나 비용을 줄일 수 있다면
                    board[nr][nc] = nextValue;
                    q.add(new Node(nr, nc, i, nextValue));
                    visited[nr][nc][i] = true;
                }
            }
        }

        return answer;
    }

    private static boolean validateRange(final int nr, final int nc, final int[][] board) {
        return nr >= 0 && nr < n && nc >= 0 && nc < m && board[nr][nc] != 1;
    }

    public static void main(String[] args) {
        Example20240411_1 sol = new Example20240411_1();

        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};// 3800
        System.out.println(sol.solution(board));
    }
}
