package com.algorithm2023.jababookbackjoon3;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Example20240402_q1197 {
    static int n;
    static int m;
    static ArrayList<Node>[] nodes;
    static boolean[] visited;
    static int answer;

    static class Node implements Comparable<Node> {
        int next;
        int weight;

        public Node(final int next, final int weight) {
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        nodes = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        answer = 0;

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int val = sc.nextInt();
            nodes[a].add(new Node(b, val));
            nodes[b].add(new Node(a, val));
        }

        dijkstra();
        System.out.println(answer);
    }

    static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();

        q.add(new Node(1, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();

            int destination = now.next;
            int weight = now.weight;

            if (visited[destination]) {
                continue;
            }

            visited[destination] = true;
            answer += weight;

            for (Node next : nodes[destination]) {
                if (!visited[next.next]) {
                    q.add(next);
                }
            }
        }
    }
}
