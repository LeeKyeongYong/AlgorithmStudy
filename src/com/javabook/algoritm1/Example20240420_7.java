package com.javabook.algoritm1;

import java.util.LinkedList;
import java.util.Queue;

public class Example20240420_7 {

    static final int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int answer; // 전역 변수 answer 추가
    static int n, m; // 맵 크기 변수 추가

    static class Node {
        int row;
        int col;
        int val;

        public Node(final int row, final int col, final int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // given
        int k = 2;
        int[][] map = {{0, 0}, {1, 0}};

        // sudo
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.row == n - 1 && now.col == m - 1) {
                answer = now.val;
            }

            for (int i = 0; i < pos.length; i++) {
                for (int moveCount = 1; moveCount <= k; moveCount++) {
                    int nr = now.row + pos[i][0] * moveCount;
                    int nc = now.col + pos[i][1] * moveCount;

                    if (!validMap(nr, nc)) {
                        continue;
                    }

                    q.add(new Node(nr, nc, now.val + 1));
                }
            }
        }
    }

    private static boolean validMap(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

}
