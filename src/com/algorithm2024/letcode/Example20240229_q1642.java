package com.algorithm2024.letcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Example20240229_q1642 {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> diff = new PriorityQueue<>(Comparator.reverseOrder());

        int answer = 0;

        int i = 0;
        for (; i < heights.length - 1; i++) {
            int step = heights[i + 1] - heights[i];

            if (step <= 0) {
                continue;
            }

            diff.add(step);
            bricks -= step;

            if (bricks < 0) {
                bricks += diff.poll();
                ladders--;
            }

            if (ladders < 0) {
                break;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        Example20240229_q1642 sol = new Example20240229_q1642();

        // 4
        System.out.println(sol.furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));

        // 7
        System.out.println(sol.furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));
    }
}
