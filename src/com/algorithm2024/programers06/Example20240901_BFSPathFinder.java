package com.algorithm2024.programers06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//프로그래머스 pccp 기출2
public class Example20240901_BFSPathFinder {

    private static final int DESTINATION = Integer.MIN_VALUE;

    static int n;
    static int m;
    static int[][] map;
    static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static class Node {
        int row;
        int col;
        List<int[]> routes = new ArrayList<>();

        public Node(final int row, final int col, final int[] route) {
            this.row = row;
            this.col = col;
            this.routes.add(route);
        }
    }

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        n = 100;
        m = routes.length;
        map = new int[n][n];

        for (int[] point : points) {
//            map[point[0] - 1][point[1] - 1] = DESTINATION;
            map[point[0] - 1][point[1] - 1] = 0;
        }

        for (int[] route : routes) {
            int[] startPos = points[route[0] - 1];
            int[] endPos = points[route[1] - 1];
            boolean[][] visited = new boolean[n][n];

            Queue<Node> q = new LinkedList<>();
            q.add(new Node(startPos[0], startPos[1], startPos));
            map[startPos[0]][startPos[1]] += 1;
            visited[startPos[0]][startPos[1]] = true;

            while (!q.isEmpty()) {
                Node now = q.poll();

                if (now.row == endPos[0] && now.col == endPos[1]) {
//                    handleMap(now);
                    break;
                }

                for (int[] p : pos) {
                    int nr = now.row + p[0];
                    int nc = now.col + p[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.add(new Node(nr, nc, new int[]{nr, nc}));
                        map[nr][nc] += 1; // 다른 목적지인 경우 고려해야함
                    }
                }
            }
        }

        return answer;
    }
}
