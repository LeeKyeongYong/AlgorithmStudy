package com.algorithm2025.backjoon.day010;

public class Example20250209_q18133 { //코딩테스트 연습  코딩 기초 트레이닝  특별한 이차원 배열 1
    public int[][] solution(int n) {
        // n x n 크기의 2차원 배열 생성
        int[][] arr = new int[n][n];

        // 대각선에 해당하는 arr[i][i]에 1을 할당
        for (int i = 0; i < n; i++) {
            arr[i][i] = 1;
        }

        // 생성된 배열을 반환
        return arr;
    }

    public static void main(String[] args) {
        Example20250209_q18133 solution = new Example20250209_q18133();

        // 테스트 예시
        int[][] result1 = solution.solution(3);
        print2DArray(result1); // [[1, 0, 0], [0, 1, 0], [0, 0, 1]]

        int[][] result2 = solution.solution(6);
        print2DArray(result2); // [[1, 0, 0, 0, 0, 0], [0, 1, 0, 0, 0, 0], [0, 0, 1, 0, 0, 0], ...]

        int[][] result3 = solution.solution(1);
        print2DArray(result3); // [[1]]
    }

    // 2차원 배열 출력 함수
    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
