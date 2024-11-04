package com.javabook.algoritm1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example20241104_q7727 {

    static int n;
    static int m;
    static int[][] map;
    static int answer;
    static boolean[][][] visited;
    static List<int[]> friends;
    static final int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        answer = 0;
        visited = new boolean[m][n][n];
        friends = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            friends.add(new int[]{sc.nextInt() - 1, sc.nextInt() - 1});
        }

        int row = friends.get(0)[0];
        int col = friends.get(0)[1];

        permutation(0, 0, 0, row, col);
        System.out.println(answer);
    }

    static void permutation(int time, int index, int sum, int row, int col) {
        if (isFirstVisit(row, col)) {
            sum += map[row][col];
        }

        visited[index][row][col] = true;

        if (time == 3) {
            if (index + 1 == m) {
                answer = Math.max(answer, sum);
            } else {
                int nr = row + friends.get(index + 1)[0];
                int nc = col + friends.get(index + 1)[1];
                permutation(0, index + 1, sum, nr, nc);
            }
            visited[index][row][col] = false;
            return;
        }

        for (int[] p : pos) {
            int nr = row + p[0];
            int nc = col + p[1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[index][nr][nc]) {
                permutation(time + 1, index, sum, nr, nc);
            }
        }

        visited[index][row][col] = false;
    }

    public static boolean isFirstVisit(int r, int c) {
        for (int i = 0; i < m; i++) {
            if (visited[i][r][c]) {
                return false;
            }
        }

        return true;
    }

}
