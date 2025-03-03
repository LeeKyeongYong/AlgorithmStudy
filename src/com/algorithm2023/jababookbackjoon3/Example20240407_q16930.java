package com.algorithm2023.jababookbackjoon3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Example20240407_q16930 {
    static int n;
    static int m;
    static int k;
    static char[][] map;
    static boolean[][] visited;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static class Node {
        int row;
        int col;
        int time;

        public Node(final int row, final int col, final int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            map[i] = str.toCharArray();
        }

        visited = new boolean[n][m];

        int sRow = sc.nextInt() - 1;
        int sCol = sc.nextInt() - 1;
        int eRow = sc.nextInt() - 1;
        int eCol = sc.nextInt() - 1;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sRow, sCol, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.row == eRow && now.col == eCol) {
                System.out.println(now.time);
                return;
            }

            for (int i = 0; i < pos.length; i++) {
                for (int j = 1; j <= k; j++) {
                    int nr = now.row + pos[i][0] * j;
                    int nc = now.col + pos[i][1] * j;

                    if (!(nr >= 0 && nr < n && nc >= 0 && nc < m)) {
                        continue;
                    }


                    if (visited[nr][nc]) {
                        continue;
                    }


                    if (map[nr][nc] == '#') {
                        break;
                    }

                    visited[nr][nc] = true;
                    q.add(new Node(nr, nc, now.time + 1));
                }
            }
        }

        System.out.println(-1);
    }
}
