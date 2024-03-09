package com.algorithm2024.programers01;

import java.util.Arrays;

public class Example20240309_04 { //거리두기확인하기 프로그래머스
    static int n;
    static char[][] map;
    static final int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static final int[][] diPos = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        n = places[0].length;

        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            map = new char[n][n];

            for (int j = 0; j < place.length; j++) {
                map[j] = place[j].toCharArray();
            }

            boolean isNoProblem = isNoProblem(map);
            if (isNoProblem) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    static boolean isNoProblem(char[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'P' && isProblem(map, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean isProblem(char[][] map, int row, int col) {
        // 상하좌우 1칸
        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (!(nr >= 0 && nr < n && nc >= 0 && nc < n)) {
                continue;
            }

            if (map[nr][nc] == 'P') {
                return true;
            }
        }

        // 상하좌우 2칸
        for (int i = 0; i < pos.length; i++) {
            int nr = row + (pos[i][0] * 2);
            int nc = col + (pos[i][1] * 2);

            if (!(nr >= 0 && nr < n && nc >= 0 && nc < n)) {
                continue;
            }

            if (map[nr][nc] == 'P' && map[(row + nr) / 2][(col + nc) / 2] == 'O') {
                return true;
            }
        }

        // 대각선
        for (int i = 0; i < diPos.length; i++) {
            int nr = row + diPos[i][0];
            int nc = col + diPos[i][1];

            if (!(nr >= 0 && nr < n && nc >= 0 && nc < n)) {
                continue;
            }

            if (map[nr][nc] == 'P' && (map[nr][col] == 'O' || map[row][nc] == 'O')) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        // [1, 0, 1, 1, 1]
        System.out.println(Arrays.toString(solution(places)));
    }
}
