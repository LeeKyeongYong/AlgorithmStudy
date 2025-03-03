package com.algorithm2023.javabook.algoritm1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Example20240420_2 {
    static int solution(int[] prices, int k) {
        int money = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < prices.length - k; i++) {
            pq = new PriorityQueue<>(Comparator.reverseOrder());
            int price = prices[i];
            int sum = 0;

            for (int j = i + 1; j < prices.length; j++) {
                pq.add(prices[j] - price);
            }

            for (int j = 0; j < k; j++) {
                sum += pq.poll();
            }

            money = Math.max(money, sum);
        }

        if (money <= 0) {
            return -1;
        }

        return money;
    }

    public static void main(String[] args) {
        int[] prices = {10, 7, 8, 5, 8, 7, 6, 2, 9};

        // 9
        System.out.println(solution(prices, 3));
    }
}
