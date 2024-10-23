package com.algorithm2024.letcode6;

import java.util.ArrayList;
import java.util.Scanner;

public class Example20241023_q10451 {

    static final StringBuilder sb = new StringBuilder();
    static final Scanner sc = new Scanner(System.in);
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) {
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            solve();
        }

        System.out.println(sb.toString());
    }

    static void solve() {
        int n = sc.nextInt();

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            list[i].add(num);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        sb.append(count).append("\n");
    }

    static void dfs(int node) {
        visited[node] = true;

        for (Integer i : list[node]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

}
