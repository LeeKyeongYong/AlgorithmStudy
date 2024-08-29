package com.algorithm2024.programers06;

import java.util.PriorityQueue;

public class Example20240829_NewEmployee {//프로그래머스 pccp 모의고사 신입사원

    public int solution(int[] ability, int number) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : ability) {
            pq.add(i);
        }

        while (number-- > 0) {
            Integer first = pq.poll();
            Integer second = pq.poll();
            int next = first + second;
            pq.add(next);
            pq.add(next);
        }

        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        Example20240829_NewEmployee sol = new Example20240829_NewEmployee();

        // 37
        System.out.println(sol.solution(new int[]{10, 3, 7, 2}, 2));
    }

}
