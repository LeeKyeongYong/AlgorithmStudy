package com.algorithm2024.programers01;

import java.util.LinkedList;
import java.util.Queue;

public class Exam20240227_launch {//카카오 시뮬레이션 프렌즈4 블록2

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            boolean flag = false;
            boolean[][] check = new boolean[m][n];

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] != '.'
                            && map[i][j] == map[i + 1][j]
                            && map[i][j] == map[i + 1][j + 1]
                            && map[i][j] == map[i][j + 1]
                    ) {
                        check[i][j] = true;
                        check[i + 1][j] = true;
                        check[i][j + 1] = true;
                        check[i + 1][j + 1] = true;
                        flag = true;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j]) {
                        map[i][j] = '.';
                    }
                }
            }

            // 3. 블럭을 터뜨리지 못하면 탈출
            if (!flag) {
                break;
            }

            // 2. 블럭 내리기
            for (int j = 0; j < n; j++) {
                Queue<Character> q = new LinkedList<>();

                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != '.') {
                        q.add(map[i][j]);
                    }
                }

                if (q.size() < m) {
                    int needMore = m - q.size();

                    for (int i = 0; i < needMore; i++) {
                        q.add('.');
                    }
                }

                for (int i = m - 1; i >= 0; i--) {
                    map[i][j] = q.poll();
                }
            }
        }

        // 4. 맵에 있는 터진 공간을 카운트
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '.') {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        int m = 6;
        int n = 6;

        // 15
        System.out.println(solution(m, n, board));
    }

}
