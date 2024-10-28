package com.algorithm2024.programers06;

import java.util.Scanner;

public class Example20241028_q21775 {
    static int n;
    static int m;
    static int t;
    static char[][] map;
    static int[] startPos;
    static int answer;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        map = new char[n][m];
        startPos = new int[2];
        answer = 0;

        for (int i = 0; i < n; i++) {
            String s = sc.next();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (c == 'G') {
                    startPos = new int[]{i, j};
                }

                map[i][j] = c;
            }
        }

        permutation(0, startPos[0], startPos[1], 0);
        System.out.println(answer);
    }

    static void permutation(int index, int row, int col, int sum) {
        if (index == t) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] != '#') {
                if (map[nr][nc] == 'S') {
                    map[nr][nc] = '.';
                    permutation(index + 1, nr, nc, sum + 1);
                    map[nr][nc] = 'S';
                } else {
                    permutation(index + 1, nr, nc, sum);
                }
            }
        }
    }
}
