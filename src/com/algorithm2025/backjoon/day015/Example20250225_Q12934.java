package com.algorithm2025.backjoon.day015;

public class Example20250225_Q12934 { // 코딩테스트 연습 연습문제 정수 제곱근 판별
    public long solution(long n) {
        long sqrt = (long) Math.sqrt(n);

        // 제곱근을 제곱했을 때 원래 수와 같은지 확인
        if (sqrt * sqrt == n) {
            return (sqrt + 1) * (sqrt + 1);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Example20250225_Q12934 sol = new Example20250225_Q12934();
        System.out.println(sol.solution(121)); // 144
        System.out.println(sol.solution(3));   // -1
    }
}
