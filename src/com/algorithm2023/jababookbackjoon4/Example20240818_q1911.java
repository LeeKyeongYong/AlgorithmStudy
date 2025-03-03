package com.algorithm2023.jababookbackjoon4;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Example20240818_q1911 {
    static class Pound {

        int start;
        int end;

        public Pound(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Pound{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int l = sc.nextInt();
        PriorityQueue<Pound> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.start == o2.start) {
                return o2.end - o1.end;
            }

            return o1.start - o2.start;
        });

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            pq.add(new Pound(start, end));
        }

        int answer = 0;
        int range = 0;
        while (!pq.isEmpty()) {
            Pound now = pq.poll();

            if (now.start > range) {
                range = now.start;
            }

            if (now.end >= range) {
                while (now.end > range) {
                    range += l;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
