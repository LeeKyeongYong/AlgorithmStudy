package com.algorithm2024.letcode4;

import java.util.Arrays;

public class Example20240731_q1334 { // 플로이드 와샬 도착하는 최소 도시 값 구하기 (좀 어려웠음)
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        int answer = -1;

        // 1. 거리 설정
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        // 2. 거리 초기화 (양방향이므로 value 양방향 설정)
        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }

        // 3. 플로이드 와샬 알고리즘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (dist[j][i] != Integer.MAX_VALUE && dist[i][k] != Integer.MAX_VALUE) {
                        dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                    }
                }
            }
        }

        // 4. 도착할 수 있는 최소 도시 수 계산
        int minCities = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int reachCity = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachCity++;
                }
            }

            if (reachCity <= minCities) {
                minCities = reachCity;
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 3번 도시
        System.out.println(findTheCity(
                4,
                new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}},
                4
        ));
    }
}
