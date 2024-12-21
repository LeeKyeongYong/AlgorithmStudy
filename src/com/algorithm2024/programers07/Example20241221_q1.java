package com.algorithm2024.programers07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Graph {
    private final List<List<Integer>> adjList;

    public Graph(int n) {
        adjList = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        adjList.get(from).add(to);
        adjList.get(to).add(from);
    }

    public List<Integer> getNeighbors(int node) {
        return adjList.get(node);
    }
}

class GPSLog {
    private final int[][] D;
    private final int INF = 987654321;

    public GPSLog(int k, int n) {
        D = new int[k][n + 1];
        for (int[] row : D) {
            Arrays.fill(row, INF);
        }
    }

    public int get(int i, int j) {
        return D[i][j];
    }

    public void set(int i, int j, int value) {
        D[i][j] = value;
    }

    public int getINF() {
        return INF;
    }
}

public class Example20241221_q1 {

    public int Example20241221_q1(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        Graph graph = new Graph(n);
        GPSLog gpsLog = new GPSLog(k, n);

        // Edge 등록
        for (int i = 0; i < m; i++) {
            int from = edge_list[i][0];
            int to = edge_list[i][1];
            graph.addEdge(from, to);
        }

        // 시작 경로 설정
        gpsLog.set(0, gps_log[0], 0);

        // GPS 로그 수정 횟수 계산
        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                gpsLog.set(i, j, Math.min(gpsLog.get(i - 1, j), gpsLog.get(i, j)));

                for (int adj : graph.getNeighbors(j)) {
                    gpsLog.set(i, j, Math.min(gpsLog.get(i - 1, adj), gpsLog.get(i, j)));
                }

                gpsLog.set(i, j, gpsLog.get(i, j) + (gps_log[i] == j ? 0 : 1));
            }
        }

        // 불가능한 경우 처리
        if (gpsLog.get(k - 1, gps_log[k - 1]) >= gpsLog.getINF()) {
            return -1;
        }

        return gpsLog.get(k - 1, gps_log[k - 1]);
    }
}
