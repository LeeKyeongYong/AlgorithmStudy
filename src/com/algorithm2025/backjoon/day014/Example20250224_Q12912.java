package com.algorithm2025.backjoon.day014;

public class Example20250224_Q12912 { //코딩테스트 연습 코딩 염습문제 두 정수 사이의 합
    public boolean solution(String s) {
        s = s.toLowerCase();
        int pCount = 0, yCount = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'p') pCount++;
            if (ch == 'y') yCount++;
        }

        return pCount == yCount;
    }

    public static void main(String[] args) {
        Example20250224_Q12912 sol = new Example20250224_Q12912();

        System.out.println(sol.solution("pPoooyY")); // true
        System.out.println(sol.solution("Pyy")); // false
    }

}
