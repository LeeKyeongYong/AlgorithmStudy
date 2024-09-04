package com.jababookbacojoon5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Example20240904_q21610 {
    static int n;
    static int m;
    static int[][] map;
    static Queue<Water> q;
    static boolean[][] visited;

    static int[][] pos = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    static class Water {
        int row;
        int col;

        public Water(final int row, final int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        q = new LinkedList<>();
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        q.add(new Water(n - 1, 0));
        q.add(new Water(n - 1, 1));
        q.add(new Water(n - 2, 0));
        q.add(new Water(n - 2, 1));

        while (m-- > 0) {
            int[] dir = pos[sc.nextInt() - 1];
            int moveCount = sc.nextInt();

            move(dir, moveCount);
            spreadWater();
            generateWater();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);
    }

    static void generateWater() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] >= 2 && !visited[i][j]) {
                    map[i][j] -= 2;
                    q.add(new Water(i, j));
                }
            }
        }
    }

    static void spreadWater() {
        visited = new boolean[n][n];

        while (!q.isEmpty()) {
            Water water = q.poll();
            visited[water.row][water.col] = true;
            int count = 0;

            for (int i = 1; i <= 7; i += 2) {
                int nr = water.row + pos[i][0];
                int nc = water.col + pos[i][1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (map[nr][nc] >= 1) {
                        count++;
                    }
                }
            }

            map[water.row][water.col] += count;
        }
    }

    static void move(final int[] dir, final int moveCount) {
        for (Water water : q) {
            water.row = (n + water.row + dir[0] * (moveCount % n)) % n;
            water.col = (n + water.col + dir[1] * (moveCount % n)) % n;
            map[water.row][water.col]++;
        }
    }
}
