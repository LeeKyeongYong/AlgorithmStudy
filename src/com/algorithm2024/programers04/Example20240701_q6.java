package com.algorithm2024.programers04;

import java.util.Arrays;

public class Example20240701_q6 { //이분탐색 입국심사
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long) Arrays.stream(times).max().getAsInt() * n;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long people = 0;

            for (int time : times) {
                people += mid / time;
                if (people >= n) {
                    break;
                }
            }

            if (people >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
