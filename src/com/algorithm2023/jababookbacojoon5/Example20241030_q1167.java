package com.algorithm2023.jababookbacojoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Example20241030_q1167 {

    static int n;
    static ArrayList<Node>[] list;
    static boolean[] visited;

    static class Node {
        int child;
        int value;

        public Node(final int child, final int value) {
            this.child = child;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[parent].add(new Node(child, value));
            list[child].add(new Node(parent, value));
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            int maxDistance = dfs(i, 0);
            answer = Math.max(answer, maxDistance);
        }

        System.out.println(answer);
    }

    static int dfs(int now, int sum) {
        int maxSum = sum;

        for (Node next : list[now]) {
            if (!visited[next.child]) {
                visited[next.child] = true;
                int nextSum = dfs(next.child, sum + next.value);
                maxSum = Math.max(maxSum, nextSum);
            }
        }

        return maxSum;
    }

}
