package com.algorithm2025.backjoon.day007;

public class Example20250204_q181898 { //코딩테스트 연습 코딩 기초 트레이닝 가까운 1 찾기
    public int solution(int[] arr, int idx) {
        // idx부터 배열 끝까지 순회
        for (int i = idx; i < arr.length; i++) {
            // 1인 첫 번째 원소 인덱스 반환
            if (arr[i] == 1) {
                return i;
            }
        }
        // 조건 만족하는 인덱스 없으면 -1 반환
        return -1;
    }
}

