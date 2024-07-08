package com.algorithm2024.programers04;

import java.util.*;

public class Example20240708_02 { //2022 KAKAO TECH INTERNSHIP 등산코스 정하기

    private static final int INF = Integer.MAX_VALUE;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int u = path[0];
            int v = path[1];
            int w = path[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        Set<Integer> gatesSet = new HashSet<>();
        for (int gate : gates) {
            gatesSet.add(gate);
        }

        Set<Integer> summitsSet = new HashSet<>();
        for (int summit : summits) {
            summitsSet.add(summit);
        }

        return getMinIntensity(n, graph, gatesSet, summitsSet);
    }

    private int[] getMinIntensity(int n, List<List<int[]>> graph, Set<Integer> gatesSet, Set<Integer> summitsSet) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] minIntensity = new int[n + 1];
        Arrays.fill(minIntensity, INF);

        for (int gate : gatesSet) {
            pq.offer(new int[]{gate, 0});
            minIntensity[gate] = 0;
        }

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int intensity = curr[1];

            if (summitsSet.contains(node) || intensity > minIntensity[node]) {
                continue;
            }

            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int weight = next[1];
                int newIntensity = Math.max(intensity, weight);

                if (newIntensity < minIntensity[nextNode] && !gatesSet.contains(nextNode)) {
                    minIntensity[nextNode] = newIntensity;
                    pq.offer(new int[]{nextNode, newIntensity});
                }
            }
        }

        int bestSummit = -1;
        int bestIntensity = INF;
        for (int summit : summitsSet) {
            if (minIntensity[summit] < bestIntensity) {
                bestIntensity = minIntensity[summit];
                bestSummit = summit;
            } else if (minIntensity[summit] == bestIntensity) {
                bestSummit = Math.min(bestSummit, summit);
            }
        }

        return new int[]{bestSummit, bestIntensity};
    }


}
//오답 테스트에서  실패처리됨
/*
    public class Example20240708_02 {

         public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 구성
        for (int[] path : paths) {
            int i = path[0];
            int j = path[1];
            int w = path[2];
            graph.get(i).add(new int[]{j, w});
            graph.get(j).add(new int[]{i, w});
        }

        // 출입구와 산봉우리 설정
        Set<Integer> gatesSet = new HashSet<>();
        for (int gate : gates) {
            gatesSet.add(gate);
        }

        Set<Integer> summitsSet = new HashSet<>();
        for (int summit : summits) {
            summitsSet.add(summit);
        }

        // 최소 인텐시티 계산
        return getMinIntensity(n, graph, gatesSet, summitsSet);
    }

    private int[] getMinIntensity(int n, List<List<int[]>> graph, Set<Integer> gatesSet, Set<Integer> summitsSet) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        // 출발지를 우선순위 큐에 삽입
        for (int gate : gatesSet) {
            pq.offer(new int[]{0, gate});
            visited[gate] = 0;
        }

        // 산봉우리에 도착할 때까지 반복
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int intensity = curr[0];
            int node = curr[1];

            if (intensity > visited[node]) {
                continue;
            }

            if (summitsSet.contains(node)) {
                continue; // 산봉우리 노드를 지나칠 필요 없음
            }

            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int weight = next[1];
                int newIntensity = Math.max(intensity, weight);
                if (newIntensity < visited[nextNode]) {
                    visited[nextNode] = newIntensity;
                    pq.offer(new int[]{newIntensity, nextNode});
                }
            }
        }

        // 가장 작은 인텐시티를 구합니다.
        int[] minIntensity = {0, Integer.MAX_VALUE};
        for (int summit : summitsSet) {
            if (visited[summit] < minIntensity[1]) {
                minIntensity[0] = summit;
                minIntensity[1] = visited[summit];
            }
        }

        return minIntensity;
    }

      }
*/