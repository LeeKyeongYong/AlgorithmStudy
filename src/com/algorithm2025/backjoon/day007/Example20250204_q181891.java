package com.algorithm2025.backjoon.day007;

public class Example20250204_q181891 { //코딩테스트 연습 코딩 기초 트레이닝 순서 바꾸기

    public int[] solution(int[] num_list, int n) {
        // 결과 배열 생성 (원본 배열과 같은 길이)
        int[] result = new int[num_list.length];

        // n번째 이후 원소들 먼저 복사
        for (int i = n; i < num_list.length; i++) {
            result[i - n] = num_list[i];
        }

        // n번째까지 원소들 뒤에 복사
        for (int i = 0; i < n; i++) {
            result[num_list.length - n + i] = num_list[i];
        }

        return result;
    }
}
