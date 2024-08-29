package com.algorithm2024.programers06;

import java.util.LinkedList;
import java.util.Queue;

public class Example20240829_cafe { //프로그래머스 pccp 모의고사 카페

    class Node {
        int menu;
        int arriveTime;

        public Node(final int menu, final int arriveTime) {
            this.menu = menu;
            this.arriveTime = arriveTime;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "menu=" + menu +
                    ", arriveTime=" + arriveTime +
                    '}';
        }
    }

    public int solution(int[] menu, int[] order, int k) {
        Queue<Node> waiting = new LinkedList<>();
        Queue<Node> customers = new LinkedList<>();
        for (int i = 0; i < order.length; i++) {
            customers.add(new Node(menu[order[i]], i * k));
        }

        int answer = 1;
        int nowTime = 0;

        while (!customers.isEmpty() || !waiting.isEmpty()) {
            if (!waiting.isEmpty() && nowTime < waiting.peek().arriveTime) {
                nowTime = waiting.peek().arriveTime;
            }

            if (waiting.isEmpty() && nowTime < customers.peek().arriveTime) {
                nowTime = customers.peek().arriveTime;
            }

            while (!customers.isEmpty() && customers.peek().arriveTime <= nowTime) {
                waiting.add(customers.poll());
            }

            nowTime += waiting.peek().menu;

            answer = Math.max(answer, waiting.size() + (waiting.size() > 1 && nowTime > waiting.peek().arriveTime ? 1 : 0));
            waiting.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        Example20240829_cafe sol = new Example20240829_cafe();

        // 3
        System.out.println(sol.solution(new int[]{5, 12, 30}, new int[]{1, 2, 0, 1}, 10));
    }

}
