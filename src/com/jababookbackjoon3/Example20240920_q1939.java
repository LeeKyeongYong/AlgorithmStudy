package com.jababookbackjoon3;

import java.util.ArrayList;
import java.util.Scanner;

public class Example20240920_q1939 {

    static int n;
    static int m;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int answer;
    static int start;
    static int end;
    static int value;

    static class Node {
        int end;
        int val;

        public Node(final int end, final int val) {
            this.end = end;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        answer = 0;
        value = -1;

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int val = sc.nextInt();

            list[from].add(new Node(to, val));
            list[to].add(new Node(from, val));
        }

        start = sc.nextInt();
        end = sc.nextInt();

        int left = 0;
        int right = 1000000000;
        while (left <= right) {
            int mid = (left + right) / 2;

            value = -1;
            visited = new boolean[n + 1];
            dfs(start, end, mid);

            if (value == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = Math.max(answer, value);
            }
        }

        System.out.println(answer);
    }

    static void dfs(int now, int end, int limit) {
        if (now == end) {
            value = limit;
            return;
        }

        visited[now] = true;
        for (Node node : list[now]) {
            if (!visited[node.end] & limit <= node.val) {
                dfs(node.end, end, limit);
            }
        }
    }
}
