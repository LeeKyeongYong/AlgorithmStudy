package com.algorithm2025.backjoon.day010;

public class Example20250209_q181834 { //코딩테스트 연습 코딩 기초 트레이닝 l로 만들기

    public String solution(String myString) {
        // StringBuilder를 사용하여 문자열을 변경
        StringBuilder result = new StringBuilder();

        // 문자열을 순차적으로 탐색
        for (char c : myString.toCharArray()) {
            // 'l'보다 앞서는 문자는 'l'로 변경
            if (c < 'l') {
                result.append('l');
            } else {
                result.append(c);
            }
        }

        // 최종 문자열 반환
        return result.toString();
    }

}
