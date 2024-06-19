package com.algorithm2024.letcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example20240619_q826 {

    static class Node {
        int diff;
        int profit;

        public Node(final int diff, final int profit) {
            this.diff = diff;
            this.profit = profit;
        }
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int answer = 0;

        // 1. 작업 난이도 오름차순 정렬
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            list.add(new Node(difficulty[i], profit[i]));
        }
        Collections.sort(list, (o1, o2) -> o1.diff - o2.diff);

        // 2. 작업자 정렬
        Arrays.sort(worker);

        // 3. 리스트별의 작업량 별로 최대 수익량을 보장할 수 있도록 트릭 추가
        int maxProfit = 0;
        for (int i = 0; i < list.size(); i++) {
            maxProfit = Math.max(maxProfit, list.get(i).profit);
            list.get(i).profit = maxProfit;
        }

        // 4. 작업자의 작업량에 따른 최대 수익 찾기
        for (int i = 0; i < worker.length; i++) {
            int left = 0;
            int right = list.size() - 1;
            int target = worker[i];

            while (left <= right) {
                int mid = (left + right) / 2;
                if (list.get(mid).diff <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (right >= 0) {
                answer += list.get(right).profit;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 100
        System.out.println(maxProfitAssignment(
                new int[]{2, 4, 6, 8, 10},
                new int[]{10, 20, 30, 40, 50},
                new int[]{4, 5, 6, 7}
        ));

        // 324
        System.out.println(maxProfitAssignment(
                new int[]{68, 35, 52, 47, 86},
                new int[]{67, 17, 1, 81, 3},
                new int[]{92, 10, 85, 84, 82}
        ));
    }

}
