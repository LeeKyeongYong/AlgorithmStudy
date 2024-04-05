package com.jababookbackjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Example20240405_q2206 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static class Node {
        int row;
        int col;
        boolean destroyed;
        int move;

        public Node(int row, int col, boolean destroyed, int move) {
            this.row = row;
            this.col = col;
            this.destroyed = destroyed;
            this.move = move;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(charArray[j]);
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(0, 0, false, 1));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.row == n - 1 && node.col == m - 1) {
                return node.move;
            }

            for (int[] p : pos) {
                int nr = node.row + p[0];
                int nc = node.col + p[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                if (node.destroyed) {
                    if (map[nr][nc] == 0 && !visited[nr][nc][1]) {
                        visited[nr][nc][1] = true;
                        queue.offer(new Node(nr, nc, true, node.move + 1));
                    }
                } else {
                    if (map[nr][nc] == 1) {
                        visited[nr][nc][1] = true;
                        queue.offer(new Node(nr, nc, true, node.move + 1));
                    } else if (!visited[nr][nc][0]) {
                        visited[nr][nc][0] = true;
                        queue.offer(new Node(nr, nc, false, node.move + 1));
                    }
                }
            }
        }

        return -1;
    }
}
