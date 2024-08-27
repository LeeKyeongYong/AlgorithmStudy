package com.algorithm2024.letcode5;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Example20240828_q1514 {
    static ArrayList<ArrayList<Node>> list;

    class Node {

        int now;
        double prob;

        public Node(final int now, final double prob) {
            this.now = now;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int start = edge[0];
            int end = edge[1];

            list.get(start).add(new Node(end, succProb[i]));
            list.get(end).add(new Node(start, succProb[i]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o2.prob, o1.prob));

        double[] dp = new double[n];
        dp[start_node] = 1;
        pq.add(new Node(start_node, 1));

        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            int now = poll.now;
            double nowProb = poll.prob;

            if (now == end_node) {
                return dp[now];
            }

            for (Node next : list.get(now)) {
                int nextPos = next.now;
                double nextProb = next.prob;

                if ((nowProb * nextProb) > dp[nextPos]) {
                    dp[nextPos] = nowProb * nextProb;
                    pq.add(new Node(nextPos, dp[nextPos]));
                }
            }
        }

        return dp[end_node];
    }

    public static void main(String[] args) {
        Example20240828_q1514 sol = new Example20240828_q1514();

        // 0.25000
        System.out.println(sol.maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5, 0.5, 0.2}, 0, 2));
    }
}
