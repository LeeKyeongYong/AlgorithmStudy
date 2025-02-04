package com.algorithm2025.backjoon.day007;

public class Example20250204_q181887 { //코딩테스트 연습 코딩 기초 트레이닝 홀수 vs 짝수

    public int solution(int[] num_list) {
        int oddSum = 0;
        int evenSum = 0;

        // 1번 원소부터 시작하므로 인덱스는 0부터
        for (int i = 0; i < num_list.length; i++) {
            // 인덱스가 홀수이면 짝수 번째 원소, 인덱스가 짝수이면 홀수 번째 원소
            if (i % 2 == 0) {
                oddSum += num_list[i];
            } else {
                evenSum += num_list[i];
            }
        }

        // 둘 중 큰 값 또는 같은 값 반환
        return Math.max(oddSum, evenSum);
    }
}
