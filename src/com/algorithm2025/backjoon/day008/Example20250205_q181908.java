package com.algorithm2025.backjoon.day008;

public class Example20250205_q181908 { //코딩테스트 연습 코딩 기초 트레이닝 접미사인지 확인하기

    public int solution(String my_string, String is_suffix) {
        // my_string의 접미사 중에서 is_suffix와 일치하는 부분이 있는지 확인
        if (my_string.endsWith(is_suffix)) {
            return 1;  // 접미사가 맞으면 1을 반환
        } else {
            return 0;  // 접미사가 아니면 0을 반환
        }
    }

    public static void main(String[] args) {
        Example20250205_q181908 sol = new Example20250205_q181908();

        // 테스트 예시들
        System.out.println(sol.solution("banana", "ana"));  // 1
        System.out.println(sol.solution("banana", "nan"));  // 0
        System.out.println(sol.solution("banana", "wxyz")); // 0
        System.out.println(sol.solution("banana", "abanana")); // 0
    }

}
