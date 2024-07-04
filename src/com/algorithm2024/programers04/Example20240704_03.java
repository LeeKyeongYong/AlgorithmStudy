package com.algorithm2024.programers04;

import java.util.Arrays;

public class Example20240704_03 { // 단속카메라

    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1])); // 진출 지점을 기준으로 정렬
        int answer = 0;
        int camera = -30001; // 초기 카메라 위치

        for (int[] route : routes) {
            if (camera < route[0]) {
                answer++;
                camera = route[1];
            }
        }
        return answer;
    }

}
