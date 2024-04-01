package com.algorithm2024.programers02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Example20240401_4 {//도넛과막대그래프
    static class Node {

        int give;
        int take;

        public Node() {
            this.give = 0;
            this.take = 0;
        }

        public Node(int give, int take) {
            this.give = give;
            this.take = take;
        }

        public void addGive() {
            this.give++;
        }

        public void addTake() {
            this.take++;
        }
    }

    public static int[] solution(int[][] edges) {
        int[] answer = new int[4];

        Map<Integer, Node> nodes = new HashMap<>();

        for (int[] edge : edges) {
            int giver = edge[0];
            int taker = edge[1];

            if (!nodes.containsKey(giver)) {
                nodes.put(giver, new Node());
            }

            if (!nodes.containsKey(taker)) {
                nodes.put(taker, new Node());
            }

            nodes.get(giver).addGive();
            nodes.get(taker).addTake();
        }

        // ans = {정점, 도넛, 막대, 8자}
        for (int key : nodes.keySet()) {
            Node node = nodes.get(key);

            // 정점
            if (node.give >= 2 && node.take == 0) {
                answer[0] = key;
                continue;
            }

            // 막대
            if (node.give == 0) {
                answer[2]++;
                continue;
            }

            // 8자
            if (node.give >= 2 && node.take >= 2) {
                answer[3]++;
            }
        }

        // 도넛
        answer[1] = nodes.get(answer[0]).give - (answer[2] + answer[3]);

        return answer;
    }

    public static void main(String[] args) {
        int[][] edges = {{2, 3}, {4, 3}, {1, 1}, {2, 1}};

        // 2 1 1 0
//        System.out.println(Arrays.toString(solution(edges)));

        // 4 0 1 2
        int[][] originalArray = {
                {4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6},
                {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}
        };
        System.out.println(Arrays.toString(solution(originalArray)));
    }
}
