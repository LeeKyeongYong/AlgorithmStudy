package com.algorithm2024.programers04;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example20240704_04 { //탐욕법(Greedy) 단속카메라

    public int solution(int[][] routes) {
        // 차량이 나간 지점(진출)을 기준으로 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        int camera = -30001; // 초기 카메라 위치

        for (int[] route : routes) {
            // 현재 카메라 위치가 현재 차량의 진입 지점보다 작은 경우 새로운 카메라 설치
            if (camera < route[0]) {
                answer++;
                camera = route[1];
            }
        }

        return answer;
    }

}
