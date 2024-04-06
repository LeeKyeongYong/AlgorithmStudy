package com.algorithm2024.programers02;

import java.util.PriorityQueue;

public class Example20240406_3 {//더 맵게
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> increase = new PriorityQueue<Integer>();

        for (int i : scoville) {
            increase.add(i);
        }

        while (increase.size() >= 2 && increase.peek() < K) {
            int first = increase.poll();
            int second = increase.poll();

            increase.add(first + second * 2);
            answer++;
        }

        if (increase.peek() >= K) {
            return answer;
        }

        return -1;
    }
}
