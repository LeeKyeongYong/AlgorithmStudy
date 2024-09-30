package com.algorithm2024.programers06;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Example20240930_01 {

    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int work : works) {
            pq.add(work);
        }

        while (n-- > 0 && !pq.isEmpty()) {
            Integer now = pq.poll() - 1;

            if (now == 0) {
                continue;
            }

            pq.add(now);
        }

        while (!pq.isEmpty()) {
            answer += (long) Math.pow(pq.poll(), 2);
        }

        return answer;
    }

    public static void main(String[] args) {
        Example20240930_01 sol = new Example20240930_01();

        // 12
        System.out.println(sol.solution(4, new int[]{4, 3, 3}));

        // 3
        System.out.println(sol.solution(3, new int[]{1, 1}));
    }

}
