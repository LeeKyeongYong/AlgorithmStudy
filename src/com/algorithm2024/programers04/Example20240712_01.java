package com.algorithm2024.programers04;

public class Example20240712_01 { //2018 KAKAO BLIND RECRUITMENT [1차] 프렌즈4블록


    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        int count = 0;
        boolean[][] toRemove;

        while (true) {
            toRemove = new boolean[m][n];
            boolean found = false;

            // Find all 2x2 blocks to remove
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char current = map[i][j];
                    if (current != ' ' && current == map[i + 1][j] && current == map[i][j + 1] && current == map[i + 1][j + 1]) {
                        toRemove[i][j] = toRemove[i + 1][j] = toRemove[i][j + 1] = toRemove[i + 1][j + 1] = true;
                        found = true;
                    }
                }
            }

            if (!found) break;

            // Count and remove blocks
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (toRemove[i][j]) {
                        count++;
                        map[i][j] = ' ';
                    }
                }
            }

            // Drop the blocks
            for (int j = 0; j < n; j++) {
                int emptyRow = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != ' ') {
                        char temp = map[i][j];
                        map[i][j] = ' ';
                        map[emptyRow][j] = temp;
                        emptyRow--;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Example20240712_01 game = new Example20240712_01();
        String[] board1 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        String[] board2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        System.out.println(game.solution(4, 5, board1));  // 14
        System.out.println(game.solution(6, 6, board2));  // 15
    }

}
