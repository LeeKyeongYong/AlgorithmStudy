package com.algorithm2024.programers03;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Example20240613_01 { // 프로그래머스 2017 카카오코드 예선 카카오 플랜즈 컬러링 북

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] visited;

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0; //영역 개수
        int maxSizeOfOneArea = 0; //가장 큰 영역
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(m, n, i, j, picture));
                    numberOfArea++;
                }
            }
        }

        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    public int bfs(int m, int n, int x, int y, int[][] picture) {
        int range = 1;
        int target = picture[x][y];
        Queue<Point> q = new LinkedList<>();

        visited[x][y] = true;
        q.offer(new Point(x, y));

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && picture[nx][ny] == target && !visited[nx][ny]) {
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    range++;
                }
            }
        }

        return range;
    }

    public static void main(String[] args) {

        Example20240613_01 sol = new Example20240613_01();

        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };

        int[] result = sol.solution(6, 4, picture);
        System.out.println(Arrays.toString(result));
    }

}
