package com.algorithm2024.programers04;

import java.util.Stack;

public class Example20240720_01 { //2017 팁스타운 짝지어 제거하기


    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        // 문자열을 한 문자씩 순회
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // 스택이 비어있는 경우 또는 현재 문자와 스택의 top이 다른 경우
            if (stack.isEmpty() || stack.peek() != currentChar) {
                stack.push(currentChar);
            } else {
                // 현재 문자와 스택의 top이 같은 경우, top을 제거
                stack.pop();
            }
        }

        // 스택이 비어있으면 짝지어 제거하기 성공, 아니면 실패
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Example20240720_01 solution = new Example20240720_01();

        // 예제 테스트
        System.out.println(solution.solution("baabaa")); // 1
        System.out.println(solution.solution("cdcd")); // 0
    }

}
