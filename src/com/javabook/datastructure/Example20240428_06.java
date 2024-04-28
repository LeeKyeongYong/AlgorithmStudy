package com.javabook.datastructure;

public class Example20240428_06 {
    public static long solution(int money, long[][] stocks) {
        long[] dp = new long[money + 1];

        for (long[] stock : stocks) {
            long price = stock[1];

            // 현재, 이전 + 가치
            for (int i = money; i >= price; i--) {
                dp[i] = Math.max(dp[i], dp[i - (int) price] + stock[0]);
            }
        }

        return dp[money];
    }

    public static void main(String[] args) {
        // 6
        System.out.println(solution(10, new long[][]{{1, 1}, {3, 5}, {3, 5}, {4, 9}}));
    }
}
