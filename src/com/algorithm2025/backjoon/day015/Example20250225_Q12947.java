package com.algorithm2025.backjoon.day015;

public class Example20250225_Q12947 { // 코딩테스트 연습 연습문제 하샤드 수
    public boolean solution(int x) {
        int sum = 0;
        int num = x;

        // 자릿수 합 구하기
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        // 하샤드 수 판별
        return x % sum == 0;
    }

    public static void main(String[] args) {
        Example20250225_Q12947 sol = new Example20250225_Q12947();
        System.out.println(sol.solution(10)); // true
        System.out.println(sol.solution(12)); // true
        System.out.println(sol.solution(11)); // false
        System.out.println(sol.solution(13)); // false
    }
}
