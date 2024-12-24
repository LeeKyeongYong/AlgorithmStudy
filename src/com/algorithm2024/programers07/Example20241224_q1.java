package com.algorithm2024.programers07;

import java.util.Arrays;

public class Example20241224_q1 {
    public class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public class TimetableProcessor {
        private int[] preSum;
        private int maxOverlap;

        public TimetableProcessor(int m) {
            // 600 ~ 1321 까지 가능한 배열 (preSum 계산)
            preSum = new int[722];
            maxOverlap = 0;
        }

        public void processTimetable(int[][] timetable, int m) {
            for (int i = 0; i < m; i++) {
                preSum[timetable[i][0] - 600]++;
                preSum[timetable[i][1] - 600 + 1]--;
            }

            int sum = 0;
            for (int i = 0; i <= 720; i++) {
                sum += preSum[i];
                preSum[i] = sum;
                maxOverlap = Math.max(maxOverlap, preSum[i]);
            }
        }

        public int getMaxOverlap() {
            return maxOverlap;
        }
    }
    class MapPlacement {
        private int n;

        public MapPlacement(int n) {
            this.n = n;
        }

        public int findMaxDist(int maxOverlap) {

            int[][] grid = new int[n][n];
            for (int dist = 2 * (n - 1); dist >= 1; dist--) {
                for (int sy = 0; sy < n; sy++) {
                    Arrays.fill(grid, 0);
                    int cnt = 0;


                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (i == 0 && j < sy) continue;


                            boolean canPlace = true;
                            for (int x = 0; x < i; x++) {
                                for (int y = 0; y < j; y++) {
                                    if (Math.abs(x - i) + Math.abs(y - j) < dist && grid[x][y] == 1) {
                                        canPlace = false;
                                        break;
                                    }
                                }
                            }

                            if (canPlace) {
                                grid[i][j] = 1;
                                if (++cnt == maxOverlap) {
                                    return dist;
                                }
                            }
                        }
                    }
                }
            }
            return 0;
        }
    }

    public int Example20241224_q1(int n, int m, int[][] timetable) {
        TimetableProcessor timetableProcessor = new TimetableProcessor(m);

        timetableProcessor.processTimetable(timetable, m);
        int maxOverlap = timetableProcessor.getMaxOverlap();

        if (maxOverlap <= 1) return 0;

        MapPlacement mapPlacement = new MapPlacement(n);
        return mapPlacement.findMaxDist(maxOverlap);
    }
}
