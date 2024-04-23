package com.algorithm2024.programers02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Example20240423_01 {//이중우선순위큐

    public static int[] solution(String[] operations) {
        int[] answer = {};

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (String o : operations) {
            if (o.startsWith("I")) {
                // insert
                int insertNum = Integer.parseInt(o.split(" ")[1]);
                pq.add(insertNum);
                continue;
            }

            if (pq.isEmpty()) {
                continue;
            }

            // pop
            if (o.equals("D -1")) {
                // 최솟값 삭제
                pq.poll();
            } else {
                // 최대값 삭제
                PriorityQueue<Integer> dec = new PriorityQueue<>(Comparator.reverseOrder());
                dec.addAll(pq);
                dec.poll();
                pq.clear();
                pq.addAll(dec);
            }
        }

        if (pq.isEmpty()) {
            return new int[]{0, 0};
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int q = pq.poll();
            max = Math.max(max, q);
            min = Math.min(min, q);
        }

        return new int[]{max, min};
    }

    public static void main(String[] args) {
        String[] op = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        // 0, 0
        System.out.println(Arrays.toString(solution(op)));

        String[] op2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        // 333, -45
        System.out.println(Arrays.toString(solution(op2)));
    }
}
