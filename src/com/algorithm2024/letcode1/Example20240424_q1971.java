package com.algorithm2024.letcode1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Example20240424_q1971 {
    static List<Integer>[] list;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        list = new List[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        boolean answer = false;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == destination) {
                answer = true;
                break;
            }

            for (int next : list[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        return answer;
    }
}
