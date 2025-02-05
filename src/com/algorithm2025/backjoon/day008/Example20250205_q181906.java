package com.algorithm2025.backjoon.day008;

import java.util.ArrayList;

public class Example20250205_q181906 { //코딩테스트 연습 코딩 기초 트레이닝 접두사인지 확인하기

    public int[] solution(int n, int k) {
        // k의 배수를 담을 ArrayList 생성
        ArrayList<Integer> multiples = new ArrayList<>();

        // 1부터 n까지 반복하며 k의 배수를 찾음
        for (int i = k; i <= n; i += k) {
            multiples.add(i);
        }

        // ArrayList를 int[] 배열로 변환
        int[] result = new int[multiples.size()];
        for (int i = 0; i < multiples.size(); i++) {
            result[i] = multiples.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Example20250205_q181906 sol = new Example20250205_q181906();

        // 예시 입력값
        int n1 = 10, k1 = 3;
        int[] result1 = sol.solution(n1, k1);
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();

        int n2 = 15, k2 = 5;
        int[] result2 = sol.solution(n2, k2);
        for (int num : result2) {
            System.out.print(num + " ");
        }
    }

}
