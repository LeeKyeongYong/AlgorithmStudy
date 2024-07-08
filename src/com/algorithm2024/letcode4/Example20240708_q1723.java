package com.algorithm2024.letcode4;

import java.util.Deque;
import java.util.LinkedList;

public class Example20240708_q1723 {

    public static int findTheWinner(int n, int k) {
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            dq.addLast(i);
        }

        while (dq.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                dq.add(dq.poll());
            }

            dq.pollFirst();
        }

        return dq.poll();
    }

    public static void main(String[] args) {
        // 3
        System.out.println(findTheWinner(5, 2));

        // 1
        System.out.println(findTheWinner(6, 5));
    }

}
