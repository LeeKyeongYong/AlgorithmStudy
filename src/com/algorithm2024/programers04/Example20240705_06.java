package com.algorithm2024.programers04;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Example20240705_06 { //디스크 컨트롤러
    public int solution(int[][] jobs) {
        // 작업을 요청 시점에 따라 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int nowTime = 0;
        int totalWaitTime = 0;
        int finish = 0;
        int jobIndex = 0;

        while (finish < jobs.length) {
            // 현재 시점에서 작업할 수 있는 작업을 힙에 추가
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= nowTime) {
                heap.add(new int[] { jobs[jobIndex][0], jobs[jobIndex][1] });
                jobIndex++;
            }

            if (!heap.isEmpty()) {
                // 힙에서 소요 시간이 가장 적은 작업을 꺼내서 처리
                int[] currentJob = heap.poll();
                nowTime += currentJob[1];
                totalWaitTime += nowTime - currentJob[0];
                finish++;
            } else {
                // 처리할 작업이 없는 경우 시간 경과
                nowTime++;
            }
        }

        return totalWaitTime / jobs.length;
    }
}
