package com.algorithm2023.jababookbackjoon4;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Example20240818_q2170 {
    static class Node {
        int start;
        int end;

        public Node(final int start, final int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.start == o2.start) {
                return o2.end - o1.end;
            }

            return o1.start - o2.start;
        });

        for (int i = 0; i < n; i++) {
            pq.add(new Node(sc.nextInt(), sc.nextInt()));
        }

        int before = -1000000000;
        int answer = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.start > before) {
                before = now.start;
            }

            if(now.end < before) {
                continue;
            }

            answer += now.end - before;
            before = now.end;
        }

        /**
         * 1 2 3 4 5 6
         *   2 3
         *       4 5
         */

        System.out.println(answer);
    }
}
