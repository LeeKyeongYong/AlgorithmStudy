package com.algorithm2023.javabook.algoritm1;

import java.util.HashMap;
import java.util.Map;

public class Example20240530_1 {

    public static int maxGoldenTickets(String[] tickets, int rollCost, String[][] shop, int money) {
        // 티켓의 가격을 저장하는 맵
        Map<String, Integer> ticketPrices = new HashMap<>();
        for (String ticket : tickets) {
            String[] parts = ticket.split(" ");
            ticketPrices.put(parts[0], Integer.parseInt(parts[1]));
        }

        // DP 배열
        int n = shop.length;
        int m = shop[0].length;
        int[][] dp = new int[n + 1][money + 1];

        // 초기 상점 상태에서의 티켓 구입
        for (int i = 0; i < m; i++) {
            for (int j = ticketPrices.get(shop[0][i]); j <= money; j++) {
                dp[1][j] = Math.max(dp[1][j], dp[1][j - ticketPrices.get(shop[0][i])] + 1);
            }
        }

        // 각 상점 상태에서의 DP 업데이트
        for (int i = 1; i < n; i++) {
            for (int k = 0; k <= money; k++) {
                dp[i + 1][k] = dp[i][k];  // 상점을 새로고침하지 않는 경우
            }
            if (money >= rollCost) {
                for (int k = rollCost; k <= money; k++) {
                    for (int j = 0; j < m; j++) {
                        int ticketCost = ticketPrices.get(shop[i][j]);
                        if (k >= rollCost + ticketCost) {
                            dp[i + 1][k] = Math.max(dp[i + 1][k], dp[i][k - rollCost - ticketCost] + 1);
                        }
                    }
                }
            }
        }

        // 최대 황금 티켓 계산
        int maxGoldenTickets = 0;
        for (int k = 0; k <= money; k++) {
            maxGoldenTickets = Math.max(maxGoldenTickets, dp[n][k] / 3);
        }

        return maxGoldenTickets;
    }


    public static void main(String[] args) {
        String[] tickets = {"A 1", "B 2", "C 3", "D 3"};
        int rollCost = 10;
        String[][] shop = {
                {"B", "C", "B", "C"},
                {"A", "A", "A", "B"},
                {"D", "D", "C", "D"}
        };
        int money = 30;

        System.out.println(maxGoldenTickets(tickets, rollCost, shop, money)); // expected output: 2

        //////////////////////////////////////

        String[] tickets2 = {"A 1", "B 2", "C 3", "D 3"};
        int rollCost2 = 10;
        String[][] shop2 = {
                {"B", "C", "B", "C"},
                {"A", "A", "A", "B"},
                {"D", "D", "C", "D"}
        };
        int money2 = 100;

        // expected output: 4
        System.out.println(maxGoldenTickets(tickets2, rollCost2, shop2, money2));

        ///////////////////////////////////////

        // 2
        System.out.println(maxGoldenTickets(
                new String[]{"A 2", "B 1"},
                1,
                new String[][]{{"A", "A", "A"}, {"A", "B", "B"}, {"A", "B", "B"}, {"A", "B", "B"}},
                9
        ));
    }
}
