package com.algorithm2024.letcode1;

public class Example20240413_q79 {
    static final int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean answer;
    static boolean[][] visited;
    static int n;
    static int m;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        answer = false;

        if (n * m < word.length()) {
            return answer;
        }

        visited = new boolean[n][m];

        char startChar = word.charAt(0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == startChar) {
                    permutation(i, j, 1, "" + startChar, board, word);
                }
            }
        }

        return answer;
    }

    static void permutation(int row, int col, int index, String sum, char[][] map, String word) {
        if (!word.startsWith(sum)) {
            return;
        }

        if (index == word.length()) {
            if (word.equals(sum)) {
                answer = true;
            }

            return;
        }

        visited[row][col] = true;
        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
                permutation(nr, nc, index + 1, sum + map[nr][nc], map, word);
            }
        }
        visited[row][col] = false;
    }
}
