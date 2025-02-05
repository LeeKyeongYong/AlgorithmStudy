package com.algorithm2025.backjoon.day008;

public class Exampe20250205_q181901 { //코딩테스트 연습 코딩 기초 트레이닝 배열 만들기 1

    public int solution(String my_string, String is_prefix) {
        // my_string이 is_prefix로 시작하는지 확인
        if (my_string.startsWith(is_prefix)) {
            return 1;  // 접두사가 맞으면 1을 반환
        } else {
            return 0;  // 접두사가 아니면 0을 반환
        }
    }

    public static void main(String[] args) {
        Exampe20250205_q181901 sol = new Exampe20250205_q181901();

        // 테스트 예시들
        System.out.println(sol.solution("banana", "ban"));  // 1
        System.out.println(sol.solution("banana", "nan"));  // 0
        System.out.println(sol.solution("banana", "abcd")); // 0
        System.out.println(sol.solution("banana", "bananan")); // 0
    }

}
