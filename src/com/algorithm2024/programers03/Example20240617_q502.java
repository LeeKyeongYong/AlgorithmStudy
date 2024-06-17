package com.algorithm2024.programers03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Example20240617_q502 {


//    static class Node {
//        int capital;
//        int profit;
//
//        public Node(final int capital, final int profit) {
//            this.capital = capital;
//            this.profit = profit;
//        }
//
//        @Override
//        public String toString() {
//            return "Node{" +
//                    "capital=" + capital +
//                    ", profit=" + profit +
//                    '}';
//        }
//    }
//
//    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
//        int money = w;
//
//        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
//            if (o1.profit == o2.profit) {
//                return o2.capital - o1.capital;
//            }
//
//            return o1.profit - o2.profit;
//        });
//
//        for (int i = 0; i < profits.length; i++) {
//            pq.add(new Node(capital[i], profits[i]));
//        }
//
//        int beforeProfit = 0;
//        while (!pq.isEmpty() && k > 0) {
//            Node poll = pq.poll();
//
//            // 현재 자본금보다 적고 && 지금까지 poll한 수익금보다 같거나 크면 갱신
//            if (money >= poll.capital && beforeProfit <= poll.profit) {
//                beforeProfit = poll.profit;
//            } else {
//                k--;
//                money += beforeProfit;
//                beforeProfit = 0;
//                pq.add(poll);
//            }
//        }
//
//        if (k >= 1) {
//            money += beforeProfit;
//        }
//
//        return money;
//    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<int[]> projects = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            projects.add(new int[]{capital[i], profits[i]});
        }
        projects.sort((a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> profitsReverseOrderHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < projects.size(); i++) {
            if (w >= projects.get(i)[0]) {
                // 구매 가능하다면
                profitsReverseOrderHeap.offer(projects.get(i)[1]);
            } else if (k > 0 && !profitsReverseOrderHeap.isEmpty()) {
                // 구매가 안되지만, 구매 횟수는 남아있고 힙이 비어있지 않다면 현재 가장 비싼 걸 구매한다
                // 구매 후 인덱스를 이전 프로젝트로 땡겨준다 (새로 구매했으니)
                k--;
                i--;
                w += profitsReverseOrderHeap.poll();
            }
        }

        // 힙이 있고, 구매 횟수도 남았다면
        while (!profitsReverseOrderHeap.isEmpty() && k > 0) {
            w += profitsReverseOrderHeap.poll();
            k--;
        }

        return w;
    }

    public static void main(String[] args) {
        // 4
//        System.out.println(findMaximizedCapital(
//                2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}
//        ));

        // 1
//        System.out.println(findMaximizedCapital(
//                1, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}
//        ));

        // 1
        System.out.println(findMaximizedCapital(
                2, 0, new int[]{1, 2, 3}, new int[]{0, 9, 10}
        ));

    }

}
