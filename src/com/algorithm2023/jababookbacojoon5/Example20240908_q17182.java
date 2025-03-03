package com.algorithm2023.jababookbacojoon5;

import java.util.Scanner;

public class Example20240908_q17182 {

    static int n;
    static int start;
    static int[][] map;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        start = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        floydWarshall();

        visited[start] = true;
        dfs(1, start, 0);
        System.out.println(answer);
    }

    static void floydWarshall() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }

    static void dfs(int count, int now, int sum) {
        if (count == n) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(count + 1, i, sum + map[now][i]);
                visited[i] = false;
            }
        }
    }

}
