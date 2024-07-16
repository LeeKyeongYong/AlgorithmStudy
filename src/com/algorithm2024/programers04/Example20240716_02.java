package com.algorithm2024.programers04;

import java.util.Stack;

public class Example20240716_02 { //큰 수 만들기

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char now = number.charAt(i);

            while (k > 0 && !stack.isEmpty() && stack.peek() < now) {
                stack.pop();
                k--;
            }

            stack.push(now);
        }

        // 필요한 만큼 제거되지 않은 경우, 뒤에서부터 제거
        while (k > 0) {
            stack.pop();
            k--;
        }

        // 스택을 answer에 추가
        for (char c : stack) {
            answer.append(c);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("1924", 2)); // 94
        System.out.println(solution("1231234", 3)); // 3234
        System.out.println(solution("4177252841", 4)); // 775841
    }

}
