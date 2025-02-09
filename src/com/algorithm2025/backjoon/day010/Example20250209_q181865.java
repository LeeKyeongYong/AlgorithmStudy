package com.algorithm2025.backjoon.day010;

public class Example20250209_q181865 { //코딩테스트 연습 코딩 기초 트레이닝 간단한 식 계산하기

    public String solution(int[] numLog) {
        // 결과 문자열을 저장할 StringBuilder 객체
        StringBuilder result = new StringBuilder();

        // numLog 배열을 비교하여 각 조작을 찾기
        for (int i = 1; i < numLog.length; i++) {
            int diff = numLog[i] - numLog[i - 1]; // 현재 값과 이전 값의 차이

            // 차이에 따른 조작 문자 추가
            if (diff == 1) {
                result.append("w");
            } else if (diff == -1) {
                result.append("s");
            } else if (diff == 10) {
                result.append("d");
            } else if (diff == -10) {
                result.append("a");
            }
        }

        // 최종 문자열 반환
        return result.toString();
    }


}
