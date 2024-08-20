package com.algorithm2024.letcode5;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Example20240820_q12845 {

    /**
     * 40, 30, 30, 20, 50
     * 내림차순 -> 순차적
     * 50 40 30 30 20
     * <p>
     * (50 + 40) -> 50, 30, 30, 20
     * (90 + 50 + 30) -> 50, 30, 20
     * (170 + 50 + 30) -> 50, 20
     * (250 + 50 + 20) -> 50
     * ==> 320
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }

        int sum = 0;
        while (pq.size() != 1) {
            Integer now = pq.poll(); // 50
            Integer next = pq.poll(); // 40
            sum += (now + next);
            pq.add(now);
        }

        System.out.println(sum);
    }
}

}
