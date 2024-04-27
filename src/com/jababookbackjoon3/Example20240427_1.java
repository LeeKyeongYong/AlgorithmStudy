package com.jababookbackjoon3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Example20240427_1 {//무지의 먹방라이브
    static class Node implements Comparable<Node> {
        int index;
        int time;

        public Node(final int index, final int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public int compareTo(final Node o) {
            return this.time - o.time;
        }
    }

    public static int solution(int[] food_times, long k) {
        long totalNeedTime = 0;
        for (int foodTime : food_times) {
            totalNeedTime += foodTime;
        }

        if (totalNeedTime <= k) {
            return -1;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.add(new Node(i + 1, food_times[i]));
        }

        long count = 0;
        long before = 0;
        long size = food_times.length;

        while (count + size * (pq.peek().time - before) <= k) {
            Node now = pq.poll();
            count += (now.time - before) * size;
            before = now.time;
            size--;
        }

        List<Node> answer = new ArrayList<>();
        while (!pq.isEmpty()) {
            answer.add(pq.poll());
        }

        Collections.sort(answer, (o1, o2) -> {
            return o1.index - o2.index;
        });

        return answer.get((int) ((k - count) % size)).index;
    }

    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        int k = 5;

        // 1
//        System.out.println(solution(food_times, k));

        System.out.println(solution(new int[]{1}, 3));
    }
}
