package com.jababookbackjoon3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Example20240408_q20166 {
    static int n;
    static int m;
    static int k;
    static HashMap<String, Integer> map;
    static char[][] graph;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    static class Node {
        int row;
        int col;
        String sum;

        public Node(final int row, final int col, final String sum) {
            this.row = row;
            this.col = col;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        map = new HashMap<>();
        graph = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < k; i++) {
            map.put(sc.next(), 0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                scan(i, j);
            }
        }

        for (String s : map.keySet()) {
            System.out.println(map.get(s));
        }
    }

    static void scan(int row, int col) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row, col, "" + graph[row][col]));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (map.containsKey(now.sum)) {
                map.put(now.sum, map.getOrDefault(now.sum, 0) + 1);
                continue;
            }

            if (now.sum.length() >= 5) {
                continue;
            }

            for (int i = 0; i < pos.length; i++) {
                int nr = (now.row + pos[i][0]) % n;
                int nc = (now.col + pos[i][1]) % m;

                if (nr < 0) {
                    nr += n;
                }

                if (nc < 0) {
                    nc += m;
                }

                q.add(new Node(nr, nc, now.sum + graph[nr][nc]));
            }
        }
    }
}
