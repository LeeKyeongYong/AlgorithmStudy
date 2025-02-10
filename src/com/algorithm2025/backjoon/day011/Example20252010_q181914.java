package com.algorithm2025.backjoon.day011;

public class Example20252010_q181914 { // 코딩테스트 연습 코딩 기초 트레이닝 9로 나눈 나머지

    public static int solution(String number) {
        int sum = 0;

        // 각 자리 숫자를 더함
        for (int i = 0; i < number.length(); i++) {
            sum += number.charAt(i) - '0';  // 문자 '0'을 빼서 숫자로 변환
        }

        // 합을 9로 나눈 나머지를 반환
        return sum % 9;
    }
}
