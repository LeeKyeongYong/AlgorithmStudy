package com.algorithm2023.jababookbacojoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Example20241030_q1967 {

    static int n;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int answer;

    static class Node {
        int child;
        int value;

        public Node(final int child, final int value) {
            this.child = child;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "child=" + child +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        answer = 0;

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());

            while (true) {
                int child = Integer.parseInt(st.nextToken());

                if (child == -1) {
                    break;
                }

                int value = Integer.parseInt(st.nextToken());
                list[parent].add(new Node(child, value));
                list[child].add(new Node(parent, value));
            }
        }

        int vertex1 = bfs(1, false);
        int targetVertex = bfs(vertex1, true);

        System.out.println(answer);
    }

    static int bfs(int node, boolean isTarget) {
        visited = new boolean[n + 1];
        visited[node] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{node, 0}); // id, distance

        int longestPathNode = -1;
        int maxDistance = -1;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (maxDistance < now[1]) {
                maxDistance = now[1];
                longestPathNode = now[0];
            }

            for (Node next : list[now[0]]) {
                if (!visited[next.child]) {
                    visited[next.child] = true;
                    q.add(new int[]{next.child, now[1] + next.value});
                }
            }
        }

        if (isTarget) {
            answer = maxDistance;
        }
        return longestPathNode;
    }

}
