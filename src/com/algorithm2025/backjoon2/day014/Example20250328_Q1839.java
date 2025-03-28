package com.algorithm2025.backjoon2.day014;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Example20250328_Q1839 { //2017 카카오코드 본선 튜브의 소개팅
    static class Point implements Comparable<Point> {
        int x, y, d, s;

        public Point(int x, int y, int d, int s) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.s = s;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.s, o.s);
        }
    }

    public int[] Example20250328_Q1839(int m, int n, int s, int[][] time_map) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int[][] chk = new int[m][n];
        for (int[] row : chk) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, 0, 0));

        int[] result = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        while (!pq.isEmpty()) {
            Point cur = pq.poll();

            if (cur.x == m - 1 && cur.y == n - 1) {
                if (cur.d < result[0] || (cur.d == result[0] && cur.s < result[1])) {
                    result[0] = cur.d;
                    result[1] = cur.s;
                }
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n || time_map[nx][ny] == -1) continue;

                int newD = cur.d + 1;
                int newS = cur.s + time_map[nx][ny];

                if (newS > s) continue;
                if (chk[nx][ny] < newD || (chk[nx][ny] == newD && result[1] <= newS)) continue;

                chk[nx][ny] = newD;
                pq.add(new Point(nx, ny, newD, newS));
            }
        }
        return result;
    }
}
