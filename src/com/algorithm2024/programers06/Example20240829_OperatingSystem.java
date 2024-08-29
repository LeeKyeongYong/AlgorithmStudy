package com.algorithm2024.programers06;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Example20240829_OperatingSystem {// 프로그래머스 pccp 모의고사 운영체제

    class Node implements Comparable<Node> {
        int score;
        int callTime;
        int runningTime;

        public Node(final int score, final int callTime, final int runningTime) {
            this.score = score;
            this.callTime = callTime;
            this.runningTime = runningTime;
        }

        @Override
        public int compareTo(final Node o) {
            if (callTime == o.callTime) {
                return score - o.score;
            }

            return callTime - o.callTime;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "score=" + score +
                    ", callTime=" + callTime +
                    ", runningTime=" + runningTime +
                    '}';
        }
    }

    public long[] solution(int[][] program) {
        long[] answer = new long[11];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        Map<Integer, Integer> waitTimes = new LinkedHashMap<>();

        for (int[] p : program) {
            pq.add(new Node(p[0], p[1], p[2]));
        }

        long runningTimeSum = 0;
        int beforeDoneTime = 0;

        /**
         * Node{score=2, callTime=0, runningTime=10}
         * Node{score=1, callTime=5, runningTime=5}
         * Node{score=3, callTime=5, runningTime=3}
         * Node{score=3, callTime=12, runningTime=2}
         */
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int waitTime = 0;

            if (now.callTime < beforeDoneTime) {
                // 기다린 경우 기다린 시간 추가
                waitTime = beforeDoneTime - now.callTime;
            }

            waitTimes.put(now.score, waitTimes.getOrDefault(now.score, 0) + waitTime);
            runningTimeSum += now.runningTime;
            beforeDoneTime += now.runningTime;
        }

        answer[0] = runningTimeSum;
        for (Integer i : waitTimes.keySet()) {
            answer[i] += waitTimes.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Example20240829_OperatingSystem sol = new Example20240829_OperatingSystem();

        // 20, 5, 0, 16, 0, 0, 0, 0, 0, 0, 0 // (10 + 1)
        System.out.println(Arrays.toString(sol.solution(new int[][]{{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}})));

        // [19, 0, 0, 4, 3, 14, 0, 0, 0, 0, 0]
//        System.out.println(Arrays.toString(sol.solution(new int[][]{{3, 6, 4}, {4, 2, 5}, {1, 0, 5}, {5, 0, 5}})));
    }

}
