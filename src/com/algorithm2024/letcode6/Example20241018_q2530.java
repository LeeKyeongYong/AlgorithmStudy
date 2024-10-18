package com.algorithm2024.letcode6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Example20241018_q2530 {
    public static long maxKelements(int[] nums, int k) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : nums) {
            pq.add(num);
        }

        while (k-- > 0 && !pq.isEmpty()) {
            Integer now = pq.poll();

            answer += now;
            now = (int) Math.ceil((double) now / 3);
            pq.add(now);
        }

        return answer;
    }

    public static void main(String[] args) {
        // 17
//        System.out.println(maxKelements(new int[]{1, 10, 3, 3, 3}, 3));

        // 2476180565
        System.out.println(maxKelements(new int[]{672579538, 806947365, 854095676, 815137524}, 3));
    }
}
