package com.algorithm2023.jababookbacojoon5;

import java.util.Map;
import java.util.Scanner;

public class Example20240901_q16274 {
    /**
     * 반례 (달팽이 케이스 -> dfs 중간부터 시작한 경우)
     * <p>
     * 3 5
     * R D R R D
     * U R R R D
     * U L L L L
     * <p>
     * 1
     */

    static int n;
    static int m;
    static int answer;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] finished;
    static Map<Character, int[]> pos = Map.of(
            'D', new int[]{1, 0},
            'R', new int[]{0, 1},
            'L', new int[]{0, -1},
            'U', new int[]{-1, 0}
    );

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        answer = 0;
        map = new char[n][m];
        visited = new boolean[n][m];
        finished = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    static void dfs(int row, int col) {
        visited[row][col] = true;

        int[] next = pos.get(map[row][col]);

        int nr = row + next[0];
        int nc = col + next[1];

        if (!visited[nr][nc]) {
            dfs(nr, nc);
        } else {
            if (!finished[nr][nc]) {
                answer++;
            }
        }

        finished[row][col] = true;
    }
}
