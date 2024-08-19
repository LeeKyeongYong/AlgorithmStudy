package com.algorithm2024.letcode5;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Example20240819_q264 {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();

        pq.add(1L);
        visited.add(1L);
        long now = 1L;

        for (int i = 0; i < n; i++) {
            now = pq.poll();

            if (visited.add(now * 2)) {
                pq.add(now * 2);
            }
            if (visited.add(now * 3)) {
                pq.add(now * 3);
            }
            if (visited.add(now * 5)) {
                pq.add(now * 5);
            }
        }

        return (int) now;
    }
}
