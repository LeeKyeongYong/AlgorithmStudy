package com.algorithm2025.backjoon.day009;

import java.util.ArrayList;

public class Example20240208_q181911 { //코딩테스트 연습 코딩 기초 트레이닝  콜라츠 수열 만들기

    public int[] solution(int n) {
        // 콜라츠 수열을 담을 리스트
        ArrayList<Integer> sequence = new ArrayList<>();

        // 초기값 n을 수열에 추가
        sequence.add(n);

        // n이 1이 될 때까지 반복
        while (n != 1) {
            if (n % 2 == 0) { // 짝수일 경우 2로 나눈다
                n = n / 2;
            } else { // 홀수일 경우 3 * n + 1을 한다
                n = 3 * n + 1;
            }
            sequence.add(n); // 수열에 현재 값을 추가
        }

        // ArrayList를 배열로 변환하여 반환
        int[] answer = new int[sequence.size()];
        for (int i = 0; i < sequence.size(); i++) {
            answer[i] = sequence.get(i);
        }

        return answer;
    }
}
