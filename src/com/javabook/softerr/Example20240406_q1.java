package com.javabook.softerr;

import java.util.*;

public class Example20240406_q1 {
    static final char EMPTY = 'E';
    static final char BOMB = 'M';
    private static final char BUTTON = 'B';

    static int n;
    static int m;
    static char[][] map;
    static boolean[][] visited;
    static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static String[] solve(String[] board, int y, int x) {
        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
        }

        if (map[y][x] == BOMB) {
            return getBomb(y, x);
        }

        bfs(y, x);
        System.out.println(Arrays.deepToString(map));
        return null;
    }

    static void bfs(int row, int col) {
        visited[row][col] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int bombCount = 0;

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc])) {
                    continue;
                }


                if (map[nr][nc] == BOMB) {
                    bombCount++;
                } else {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }

            if (bombCount != 0) {
                map[now[0]][now[1]] = Character.forDigit(bombCount, 10);
            } else {
                map[now[0]][now[1]] = BUTTON;
            }
        }
    }

    static String[] getBomb(int row, final int col) {
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char[] cols = map[i];

            for (int j = 0; j < cols.length; j++) {
                if (i == row && j == col) {
                    sb.append("X");
                } else if (map[i][j] == BOMB) {
                    sb.append("M");
                } else {
                    sb.append("E");
                }
            }

            result[i] = sb.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        String[] board = {"EEEEE", "EEMEE", "EEEEE", "EEEEE"};

        // B1E1B B1E1B B111B BBBBB
        System.out.println(Arrays.toString(solve(board, 2, 0)));

        String[] board2 = {"MME", "EEE", "EME"};
        // XME EEE EME
        System.out.println(Arrays.toString(solve(board2, 0, 0)));
    }
}
