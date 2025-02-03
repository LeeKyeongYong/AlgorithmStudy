package com.algorithm2025.backjoon.day006;

public class Example20250203_q181868 { //코딩테스트 연습 코딩 기초 트레이닝 공백으로 구분하기 2
    public String[] solution(String my_string) {
        // 문자열 앞뒤 공백 제거
        String trimmedString = my_string.trim();
        // 하나 이상의 공백을 기준으로 단어 분리
        return trimmedString.split(" +");
    }
}
