package com.algorithm2025.backjoon.day007;

public class Example20250204_q181888 { // 코딩테스트 연습 코딩 기초 트레이닝 n개 간격의 원소들

    public int[] solution(int[] num_list, int n) {
        // 결과 리스트의 길이 계산
        int resultLength = (num_list.length - 1) / n + 1;
        int[] result = new int[resultLength];

        // n개 간격으로 원소 선택
        for (int i = 0; i < resultLength; i++) {
            result[i] = num_list[i * n];
        }

        return result;
    }
}
