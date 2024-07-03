package com.algorithm2024.programers04;

import java.util.Arrays;

public class Example20240703_02 {// 선입 선출 스케줄링

    public int solution(int n, int[] cores) {
        if (n <= cores.length) {
            return n;
        }

        n -= cores.length; // 이미 처리된 작업 수
        int left = 1;
        int right = Arrays.stream(cores).max().getAsInt() * n;

        // 이분 탐색으로 작업을 완료하는 데 걸리는 최소 시간을 찾는다
        while (left < right) {
            int mid = (left + right) / 2;
            long capacity = 0;
            for (int core : cores) {
                capacity += mid / core;
            }

            if (capacity >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // 작업 완료 시간을 결정한 후, 마지막 작업이 끝나는 코어를 찾는다
        int remainingTime = left - 1;
        int remainingTasks = n;
        for (int core : cores) {
            remainingTasks -= remainingTime / core;
        }

        for (int i = 0; i < cores.length; i++) {
            if (left % cores[i] == 0) {
                remainingTasks--;
                if (remainingTasks == 0) {
                    return i + 1;
                }
            }
        }

        return -1; // 이 코드는 도달하지 않아야 합니다.
    }

}
