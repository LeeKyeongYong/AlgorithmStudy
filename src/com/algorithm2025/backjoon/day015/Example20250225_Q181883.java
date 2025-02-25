package com.algorithm2025.backjoon.day015;

public class Example20250225_Q181883 { //코딩테스트 연습 코딩 기초 트레이닝 수열과 구간 쿼리 1
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            int s = query[0];
            int e = query[1];

            for (int i = s; i <= e; i++) {
                arr[i] += 1;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Example20250225_Q181883 sol = new Example20250225_Q181883();
        int[] result = sol.solution(new int[]{0, 1, 2, 3, 4}, new int[][]{{0, 1}, {1, 2}, {2, 3}});

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
