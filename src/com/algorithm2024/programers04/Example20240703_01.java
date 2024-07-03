package com.algorithm2024.programers04;

import java.util.Arrays;

public class Example20240703_01 {//선 연결하기
    // Union-Find 구조의 클래스
    static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        // Find 함수
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        // Union 함수
        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public int solution(int n, int[][] costs) {
        // 엣지를 비용에 따라 정렬
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        UnionFind uf = new UnionFind(n);
        int answer = 0;

        // Kruskal 알고리즘 적용
        for (int[] cost : costs) {
            int u = cost[0];
            int v = cost[1];
            int weight = cost[2];

            if (uf.find(u) != uf.find(v)) {
                uf.union(u, v);
                answer += weight;
            }
        }

        return answer;
    }
}
