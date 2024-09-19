package com.algorithm2024.programers06;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Example20240919_q19 {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        int answer = 1;
        int beforeEnd = targets[0][1];

        for (int i = 1; i < targets.length; i++) {
            int[] target = targets[i];

            if (target[0] < beforeEnd) {
                continue;
            }

            answer++;
            beforeEnd = target[1];
        }

        return answer;
    }


    public int solution2(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }

            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        pq.add(targets[0][1]);
        answer++;

        for (int i = 1; i < targets.length; i++) {
            int[] target = targets[i];

            if (pq.peek() > target[0]) {
                continue;
            }

            pq.add(target[1]);
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Example20240919_q19 sol = new Example20240919_q19();

        // 3
        System.out.println(sol.solution(
                new int[][]{
                        {4, 5},
                        {4, 8},
                        {10, 14},
                        {11, 13},
                        {5, 12},
                        {3, 7},
                        {1, 4}
                }
        ));
    }
}
