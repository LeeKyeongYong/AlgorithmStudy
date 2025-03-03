package com.algorithm2023.jababookbacojoon5;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Example20241030_q2665 {

    static int n;
    static int[][] map;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] dp;

    static class Node {
        int row;
        int col;
        int crash;

        public Node(int row, int col, int crash) {
            this.row = row;
            this.col = col;
            this.crash = crash;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = sc.next();

            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int[] anInt : dp) {
            Arrays.fill(anInt, Integer.MAX_VALUE);
        }

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.crash - o2.crash);
        q.add(new Node(0, 0, 0));
        dp[0][0] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int[] p : pos) {
                int nr = now.row + p[0];
                int nc = now.col + p[1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < n)) {
                    continue;
                }

                int wall = map[nr][nc] == 0 ? 1 : 0;

                if (dp[nr][nc] > now.crash + wall) {
                    dp[nr][nc] = now.crash + wall;
                    q.add(new Node(nr, nc, dp[nr][nc]));
                }
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }

}
