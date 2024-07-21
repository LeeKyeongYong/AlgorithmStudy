package com.algorithm2024.programers04;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Example20240721_02 { //2023 현대모비스 알고리즘 경진대회 예선 상담원 인원

    private List<List<int[]>> waitingList;
    private int k, n;
    private int result = Integer.MAX_VALUE;

    public int solution(int k, int n, int[][] reqs) {
        this.k = k;
        this.n = n;
        waitingList = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            waitingList.add(new ArrayList<>());
        }

        for (int[] req : reqs) {
            waitingList.get(req[2] - 1).add(new int[]{req[0], req[0] + req[1]});
        }

        dfs(new int[k], 0, n);

        return result;
    }

    private void dfs(int[] mentors, int index, int remainingMentors) {
        if (index == k - 1) {
            mentors[index] = remainingMentors;
            int totalWaitTime = calculateTotalWaitTime(mentors);
            result = Math.min(result, totalWaitTime);
            return;
        }

        for (int i = 1; i <= remainingMentors - (k - index - 1); i++) {
            mentors[index] = i;
            dfs(mentors, index + 1, remainingMentors - i);
        }
    }

    private int calculateTotalWaitTime(int[] mentors) {
        int totalTime = 0;
        for (int i = 0; i < k; i++) {
            totalTime += calculateWaitTime(waitingList.get(i), mentors[i]);
        }
        return totalTime;
    }

    private int calculateWaitTime(List<int[]> waitings, int mentorCount) {
        PriorityQueue<Integer> counselList = new PriorityQueue<>();
        int totalWaitTime = 0;

        for (int i = 0; i < mentorCount; i++) {
            counselList.offer(0);
        }

        for (int[] waiting : waitings) {
            int start = waiting[0];
            int end = waiting[1];
            int prevEnd = counselList.poll();

            if (start > prevEnd) {
                counselList.offer(end);
            } else {
                int waitTime = prevEnd - start;
                totalWaitTime += waitTime;
                counselList.offer(end + waitTime);
            }
        }

        return totalWaitTime;
    }

}
