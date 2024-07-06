package com.algorithm2024.programers04;

public class Example20240706_05 { //정수 삼각형

    public static int solution(int[][] triangle) {
        int n = triangle.length; // 삼각형의 층 수

        // 삼각형의 바닥층부터 시작하여 위층으로 이동
        for (int floor = n - 1; floor > 0; floor--) {
            for (int i = 0; i < floor; i++) {
                // 현재 층의 i번째 원소에 아래 층의 i번째와 i+1번째 원소 중 최대 값을 더합니다.
                triangle[floor - 1][i] += Math.max(triangle[floor][i], triangle[floor][i + 1]);
            }
        }

        // 삼각형의 맨 위에서 최대 값을 반환합니다.
        return triangle[0][0];
    }

}
