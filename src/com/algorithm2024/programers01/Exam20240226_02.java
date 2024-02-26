package com.algorithm2024.programers01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exam20240226_02 {//미로탈출명령어_완탐_시간초과
    static int[][] map;
    static int[] startPoint;
    static int[] endPoint;
    static List<String> answer;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = new ArrayList<>();
        map = new int[n][m];
        startPoint = new int[]{x - 1, y - 1};
        endPoint = new int[]{r - 1, c - 1};

        permutation(0, n, m, x - 1, y - 1, k, new StringBuilder());

        if (answer.isEmpty()) {
            return "impossible";
        }

        Collections.sort(answer);
        return answer.get(0);
    }

    static void permutation(int index, int n, int m, int row, int col, int k, StringBuilder sb) {
        if (index == k) {
            if (row == endPoint[0] && col == endPoint[1]) {
                answer.add(sb.toString());
            }
            return;
        }

        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (!(nr >= 0 && nr < n && nc >= 0 && nc < m)) {
                continue;
            }

            if (i == 0) {
                sb.append("r");
            } else if (i == 1) {
                sb.append("l");
            } else if (i == 2) {
                sb.append("d");
            } else {
                sb.append("u");
            }

            permutation(index + 1, n, m, nr, nc, k, sb);
            sb.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        // dllrl
        System.out.println(solution(3, 4, 2, 3, 3, 1, 5));
    }
}
