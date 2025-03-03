package com.algorithm2023.jababookbackjoon3;

import java.util.Arrays;

public class Example20240403_q452 {
    public static int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }

            return o1[0] - o2[0];
        });

        int answer = 1;
        int beforeEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // 이전보다 지금이 더 큰 경우
            if (points[i][0] > beforeEnd) {
                answer++;
                beforeEnd = points[i][1];
                continue;
            }

            // 이전 종료가 현재 종료보다 더 큰 경우
            if (beforeEnd > points[i][1]) {
                answer++;
                beforeEnd = points[i][1];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 2
        System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));

        // 4
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));

        // 2
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
    }
}
