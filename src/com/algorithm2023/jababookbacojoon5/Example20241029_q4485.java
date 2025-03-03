package com.algorithm2023.jababookbacojoon5;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Example20241029_q4485 {

    static final StringBuilder sb = new StringBuilder();
    static final Scanner sc = new Scanner(System.in);

    static int n;
    static int[][] map;
    static int[][] dp;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static class Node implements Comparable<Node> {
        int row;
        int col;
        int val;

        public Node(final int row, final int col, final int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public int compareTo(final Node o) {
            return this.val - o.val;
        }
    }

    public static void main(String[] args) {
        int index = 1;
        while (true) {
            n = sc.nextInt();

            if (n == 0) {
                System.out.println(sb.toString());
                return;
            }

            solve(index);
            index++;
        }
    }

    static void solve(int problem) {
        map = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, map[0][0]));

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int[] p : pos) {
                int nr = now.row + p[0];
                int nc = now.col + p[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (now.val + map[nr][nc] < dp[nr][nc]) {
                        dp[nr][nc] = now.val + map[nr][nc];
                        q.add(new Node(nr, nc, dp[nr][nc]));
                    }
                }
            }
        }

        sb.append("Problem " + problem + ": " + dp[n - 1][n - 1])
                .append("\n");
    }

}
