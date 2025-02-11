package com.algorithm2025.backjoon.day012;

public class Example20240211_Q181844 { //코딩테스트 연습 코딩 기초 트레이닝 배열의 원소 삭제하기

    public int solution(int[][] arr) {
        int n = arr.length;  // arr의 크기 (n x n)

        // 이차원 배열을 순회하며 대칭성 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != arr[j][i]) {
                    return 0;  // 대칭성이 만족되지 않으면 0을 반환
                }
            }
        }

        return 1;  // 대칭성이 만족되면 1을 반환
    }

}
