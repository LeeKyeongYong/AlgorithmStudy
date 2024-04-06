package com.algorithm2024.programers02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Example20240406_2 {//섬연결하기
    static int[] parent;

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];

            // 이미 연결 됐다면 value를 더할 필요가 없음
            if (find(a) == find(b)) {
                continue;
            }

            answer += cost[2];
            union(a, b);

            Set<Integer> set = new HashSet<>();
            for (int i : parent) {
                set.add(find(i));
            }

            if (set.size() == 1) {
                return answer;
            }
        }

        return answer;
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
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

        // 4
        System.out.println(solution(n, costs));
    }
}
