package com.algorithm2024.programers04;

import java.util.Arrays;

public class Example20240721_01 { //Summer/Winter Coding(~2018) 숫자 게임

    public int solution(int[] A, int[] B) {
        // 배열 A와 B를 오름차순으로 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        int j = 0; // B를 가리키는 인덱스
        int ans = 0; // 점수

        // A 배열의 각 요소와 B 배열의 현재 인덱스를 비교
        for (int i = 0; i < A.length; i++) {
            while (j < B.length && A[i] >= B[j]) {
                j++; // B에서 더 큰 값을 찾기
            }
            if (j < B.length) {
                ans++; // 조건에 맞는 경우 점수 증가
                j++; // B를 가리키는 인덱스 증가
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Example20240721_01 solution = new Example20240721_01();
        int[] A = {1, 3, 2, 5, 4};
        int[] B = {2, 4, 3, 6, 5};
        System.out.println(solution.solution(A, B)); // 결과 출력
    }
}
