package com.algorithm2025.backjoon.day015;

public class Example20250225_Q181838 { //코딩테스트 연습 코딩 기초 트레이닝 날짜 비교하기
    public int solution(int[] date1, int[] date2) {
        for (int i = 0; i < 3; i++) {
            if (date1[i] < date2[i]) return 1;
            if (date1[i] > date2[i]) return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        Example20250225_Q181838 sol = new Example20250225_Q181838();
        System.out.println(sol.solution(new int[]{2021, 12, 28}, new int[]{2021, 12, 29})); // 1
        System.out.println(sol.solution(new int[]{1024, 10, 24}, new int[]{1024, 10, 24})); // 0
    }
}
