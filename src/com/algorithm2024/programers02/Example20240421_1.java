package com.algorithm2024.programers02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Example20240421_1 {//전략망 문제
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] w : wires) {
            graph[w[0]].add(w[1]);
            graph[w[1]].add(w[0]);
        }

        for (int[] w : wires) {
            int a = w[0];
            int b = w[1];

            int aCount = bfs(a, b, n);
            int bCount = bfs(b, a, n);

            answer = Math.min(answer, Math.abs(aCount - bCount));
        }

        return answer;
    }

    static int bfs(int start, int target, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        visited = new boolean[n + 1];
        visited[start] = true;
        int count = 1;

        while (!q.isEmpty()) {
            Integer now = q.poll();

            for (Integer next : graph[now]) {
                if (next == target) {
                    continue;
                }

                if (visited[next]) {
                    continue;
                }

                visited[next] = true;
                count++;
                q.add(next);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int n = 9;

        // 3
        System.out.println(solution(n, wires));
    }
}
