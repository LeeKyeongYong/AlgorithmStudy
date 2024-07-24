package com.algorithm2024.programers04;

import java.util.LinkedList;
import java.util.Queue;

public class Example20240725_01 { // 깊이/너비 우선 탐색(DFS/BFS) 네트워크

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int com = 0; com < n; com++) {
            if (!visited[com]) {
                BFS(n, computers, com, visited);
                answer++;
            }
        }

        return answer;
    }

    public static void BFS(int n, int[][] computers, int com, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(com);
        visited[com] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 0; i < n; i++) {
                if (!visited[i] && computers[current][i] == 1) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

}
