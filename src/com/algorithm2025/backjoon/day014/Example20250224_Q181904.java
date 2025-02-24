package com.algorithm2025.backjoon.day014;

public class Example20250224_Q181904 { //코딩테스트 연습 코딩 기초 트레이닝 세로 읽기
    public String solution(String my_string, int m, int c) {
        StringBuilder result = new StringBuilder();

        for (int i = c - 1; i < my_string.length(); i += m) {
            result.append(my_string.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Example20250224_Q181904 sol = new Example20250224_Q181904();

        System.out.println(sol.solution("ihrhbakrfpndopljhygc", 4, 2)); // "happy"
        System.out.println(sol.solution("programmers", 1, 1)); // "programmers"
    }
}