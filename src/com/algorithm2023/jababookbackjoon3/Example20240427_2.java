package com.algorithm2023.jababookbackjoon3;

import java.util.*;
import java.util.stream.IntStream;

public class Example20240427_2 {//무지의 먹방라이브
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
            long totalNeedTime = Arrays.stream(food_times).asLongStream().sum();
            if (totalNeedTime <= k) {
                return -1;
            }

            PriorityQueue<Node> pq = IntStream.range(0, food_times.length)
                    .mapToObj(i -> new Node(i + 1, food_times[i]))
                    .collect(PriorityQueue::new, PriorityQueue::add, PriorityQueue::addAll);

            long count = 0;
            long before = 0;
            long size = food_times.length;

            while (count + (pq.peek().time - before) * size <= k) {
                Node now = pq.poll();
                count += (now.time - before) * size;
                before = now.time;
                size--;
            }

            return pq.stream()
                    .sorted(Comparator.comparingInt(o -> o.index))
                    .skip((int) ((k - count) % size))
                    .findFirst()
                    .map(node -> node.index)
                    .orElse(-1);
        }

        public static void main(String[] args) {
            int[] food_times = {3, 1, 2};
            int k = 5;
            System.out.println(solution(food_times, k)); // 1
            System.out.println(solution(new int[]{1}, 3)); // 1
        }
    }