package com.algorithm2023.jababookbacojoon5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Example20240908_q14442 {

    static int n;
    static int m;
    static int k;
    static int[][] map;
    static int[][][] visited;
    static int answer = -1;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static class Node {
        int row;
        int col;
        int dist;
        int wall;

        public Node(int row, int col, int dist, int wall) {
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.wall = wall;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        map = new int[n][m];
        visited = new int[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, k));
        visited[0][0][k] = 1;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.row == n - 1 && now.col == m - 1) {
                answer = now.dist;
                return;
            }

            for (int[] p : pos) {
                int nr = now.row + p[0];
                int nc = now.col + p[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (map[nr][nc] == 0 && visited[nr][nc][now.wall] == 0) {
                        visited[nr][nc][now.wall] = 1;
                        q.add(new Node(nr, nc, now.dist + 1, now.wall));
                    }

                    if (map[nr][nc] == 1 && now.wall > 0 && visited[nr][nc][now.wall - 1] == 0) {
                        visited[nr][nc][now.wall - 1] = 1;
                        q.add(new Node(nr, nc, now.dist + 1, now.wall - 1));
                    }
                }
            }
        }
    }
}
