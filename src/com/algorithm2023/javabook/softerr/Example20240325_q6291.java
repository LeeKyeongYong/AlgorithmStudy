package com.algorithm2023.javabook.softerr;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Example20240325_q6291 {
    static class Plan implements Comparable<Plan>{
        String name;
        int startTime;
        int playTime;

        public Plan(String name, int startTime, int playTime) {
            this.name = name;
            this.startTime = startTime;
            this.playTime = playTime;
        }
        @Override
        public int compareTo(final Plan o) {
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            pq.add(new int[]{start, end});
        }

        int beforeEnd = 0;
        int answer = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (now[0] >= beforeEnd) {
                answer++;
                beforeEnd = now[1];
            }
        }

        System.out.println(answer);
    }
}
