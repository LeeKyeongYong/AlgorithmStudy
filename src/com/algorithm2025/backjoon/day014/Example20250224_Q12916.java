package com.algorithm2025.backjoon.day014;

public class Example20250224_Q12916 { //코딩테스트 연습 문자열 내 p와 y의 개수
    public long solution(int a, int b) {
        long sum = 0;
        int start = Math.min(a, b);
        int end = Math.max(a, b);

        for (int i = start; i <= end; i++) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        Example20250224_Q12916 sol = new Example20250224_Q12916();

        System.out.println(sol.solution(3, 5)); // 12
        System.out.println(sol.solution(3, 3)); // 3
        System.out.println(sol.solution(5, 3)); // 12
    }

}
