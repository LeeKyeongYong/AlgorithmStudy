package com.algorithm2024.letcode;

public class Exam20240205_q121 {

    public int maxProfit(int[] prices) {
        int answer = 0;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];

            min = Math.min(price, min);

            if (price > min) {
                answer = Math.max(answer, price - min);
            }
        }

        return answer;
    }
}
