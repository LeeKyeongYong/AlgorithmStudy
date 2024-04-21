package com.jababookbackjoon3;

import java.util.*;

public class Example20240421_q17142 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static List<int[]> virusList;
    static int empty;
    static int answer;

    static class Virus {
        int row;
        int col;
        int time;

        public Virus(final int row, final int col, final int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        empty = 0;
        answer = Integer.MAX_VALUE;
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        virusList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    virusList.add(new int[]{i, j});
                }

                if (map[i][j] == 0) {
                    empty++;
                }
            }
        }


        if (empty == 0) {
            System.out.println(0);
        } else {
            permutation(0, 0, new int[m][2]);
            if (answer == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(answer);
            }
        }
    }

    static void permutation(int index, int start, int[][] viruses) {
        if (index == m) {
            bfs(viruses, empty);
            return;
        }

        for (int i = start; i < virusList.size(); i++) {
            viruses[index] = virusList.get(i);
            permutation(index + 1, i + 1, viruses);
        }
    }

    static void bfs(int[][] viruses, int emptySpace) {
        Queue<Virus> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        for (int[] virus : viruses) {
            q.add(new Virus(virus[0], virus[1], 0));
            visited[virus[0]][virus[1]] = true;
        }

        int time = 0;
        while (!q.isEmpty()) {
            Virus now = q.poll();

            for (int[] p : pos) {
                int nr = now.row + p[0];
                int nc = now.col + p[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && map[nr][nc] != 1) {
                    if (map[nr][nc] == 0) {
                        emptySpace--;
                    }

                    if (emptySpace == 0) {
                        answer = Math.min(answer, now.time + 1);
                        return;
                    }

                    visited[nr][nc] = true;
                    q.add(new Virus(nr, nc, now.time + 1));
                }
            }
        }
    }
}
