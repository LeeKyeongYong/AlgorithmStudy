package com.algorithm2023.javabook.softerr;

import java.util.*;

public class Example20240406_q2 {
    static int[] parent;

    public static int solve(int n, int[][] networks, int[][] repair) {
        parent = new int[n + 1];
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] network : networks) {
            union(network[0], network[1]);
        }

        Arrays.sort(repair, (o1, o2) -> o1[2] - o2[2]);
        for (int[] r : repair) {
            int a = r[0];
            int b = r[1];

            union(a, b);
            answer += r[2];

            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                set.add(find(i));
            }

            if (set.size() == 1) {
                return answer;
            }
        }

        return -1;
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x <= y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return find(parent[x]);
    }

    public static void main(String[] args) {
        int[][] net = {{1, 2}, {3, 5}, {4, 2}, {5, 6}};
        int[][] rep = {{3, 2, 10}, {5, 4, 15}};

        // 10
        System.out.println(solve(6, net, rep));

        // -1
        System.out.println(solve(4, new int[][]{{1, 2}}, new int[][]{{2, 3, 10}, {3, 1, 12}}));
    }
}
