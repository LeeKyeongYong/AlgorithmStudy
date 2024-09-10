package com.algorithm2024.programers06;

import java.util.*;

public class Example20240910_GraphOptimization { //신비로운 유적 탐험 복습

        static final int INF = Integer.MAX_VALUE;

        static class Edge {
            int to, cap, cost, rev;

            Edge(int to, int cap, int cost, int rev) {
                this.to = to;
                this.cap = cap;
                this.cost = cost;
                this.rev = rev;
            }
        }

        static class Graph {
            List<List<Edge>> G;
            int size, src, sink;
            int[] dist, par, edgeIdx;

            Graph(int size, int src, int sink) {
                this.size = size;
                this.src = src;
                this.sink = sink;
                G = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    G.add(new ArrayList<>());
                }
                dist = new int[size];
                par = new int[size];
                edgeIdx = new int[size];
            }

            boolean spfa() {
                Arrays.fill(dist, INF);
                dist[src] = 0;
                PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(node -> dist[node]));
                queue.add(src);

                while (!queue.isEmpty()) {
                    int here = queue.poll();

                    if (dist[here] == INF) continue;

                    for (int i = 0; i < G.get(here).size(); i++) {
                        Edge e = G.get(here).get(i);
                        if (e.cap > 0 && dist[here] + e.cost < dist[e.to]) {
                            dist[e.to] = dist[here] + e.cost;
                            par[e.to] = here;
                            edgeIdx[e.to] = i;
                            queue.add(e.to);
                        }
                    }
                }

                return dist[sink] < INF;
            }

            int[] getMCMF() {
                int maxFlow = 0;
                int minCost = 0;

                while (spfa()) {
                    int minFlow = INF;
                    int costSum = 0;

                    for (int p = sink; p != src; p = par[p]) {
                        Edge e = G.get(par[p]).get(edgeIdx[p]);
                        minFlow = Math.min(minFlow, e.cap);
                        costSum += e.cost;
                    }

                    for (int p = sink; p != src; p = par[p]) {
                        Edge e = G.get(par[p]).get(edgeIdx[p]);
                        e.cap -= minFlow;
                        G.get(e.to).get(e.rev).cap += minFlow;
                    }

                    maxFlow += minFlow;
                    minCost += costSum * minFlow;
                }

                return new int[] {maxFlow, minCost};
            }

            void addEdge(int from, int to, int cap, int cost) {
                G.get(from).add(new Edge(to, cap, cost, G.get(to).size()));
                G.get(to).add(new Edge(from, 0, -cost, G.get(from).size() - 1));
            }
        }

        static List<Integer>[] G1;
        static List<Integer>[] G2;
        static int[][] dp;

        public static void initializeGraph(int size) {
        G1 = new ArrayList[size];
        G2 = new ArrayList[size];
        dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            G1[i] = new ArrayList<>();
            G2[i] = new ArrayList<>();
        }
    }

        static int go(int cur1, int dad1, int cur2, int dad2) {
        if (dp[cur1][cur2] != -1) return dp[cur1][cur2];

        int N1 = G1[cur1].size();
        int N2 = G2[cur2].size();
        int src = N1 + N2;
        int sink = src + 1;

        Graph mcmf = new Graph(2 + N1 + N2, src, sink);

        for (int i = 0; i < N1; i++) {
            int u = G1[cur1].get(i);
            if (u == dad1) continue;
            for (int j = 0; j < N2; j++) {
                int v = G2[cur2].get(j);
                if (v == dad2) continue;
                int cost = go(u, cur1, v, cur2);
                mcmf.addEdge(i, N1 + j, 1, -cost);
            }
            mcmf.addEdge(src, i, 1, 0);
        }

        for (int i = 0; i < N2; i++) {
            mcmf.addEdge(N1 + i, sink, 1, 0);
        }

        int[] result = mcmf.getMCMF();
        dp[cur1][cur2] = -result[1] + 1;
        return dp[cur1][cur2];
    }

        public static int solution(int n1, int[][] g1, int n2, int[][] g2) {
        initializeGraph(103);
        for (int[] v : g1) {
            G1[v[0]].add(v[1]);
            G1[v[1]].add(v[0]);
        }
        for (int[] v : g2) {
            G2[v[0]].add(v[1]);
            G2[v[1]].add(v[0]);
        }
        for (int i = 0; i < 103; i++) {
            Arrays.fill(dp[i], -1);
        }
        return go(1, 0, 1, 0);
    }
}