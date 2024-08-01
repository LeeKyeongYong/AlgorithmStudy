package com.algorithm2024.programers05;

import java.util.*;

public class Example20240801_02 { //가장 먼 노드
    public static int solution(int n, int[][] edge) {
        // 그래프를 인접 리스트 형태로 생성
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보를 그래프에 추가
        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        // BFS를 위한 큐와 거리 배열
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1); // 거리 배열 초기화
        distance[1] = 0; // 출발 노드의 거리 초기화
        queue.add(1); // 시작 노드 추가

        // BFS 수행
        while (!queue.isEmpty()) {
            int now = queue.poll(); // 현재 노드
            for (int neighbor : graph[now]) {
                if (distance[neighbor] == -1) { // 아직 방문하지 않은 노드
                    queue.add(neighbor);
                    distance[neighbor] = distance[now] + 1; // 거리 갱신
                }
            }
        }

        // 가장 멀리 떨어진 노드 개수 세기
        int maxDistance = Arrays.stream(distance).max().orElse(0);
        int count = 0;
        for (int dist : distance) {
            if (dist == maxDistance) {
                count++;
            }
        }

        return count;
    }
}
