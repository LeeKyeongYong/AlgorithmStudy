package com.algorithm2025.backjoon.day04;

import java.util.Scanner;

    public class Example20250104_re_q5 { //3003 킹 퀸 록 비숍 나이트, 폰
        public static void main(String[] args) {
            int[] A = {1, 1, 2, 2, 2, 8};

            try (Scanner sc = new Scanner(System.in)) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < A.length; i++) {
                    int temp = sc.nextInt();  // 입력받은 값
                    int diff = A[i] - temp;   // 차이 계산
                    result.append(diff).append(" ");  // 차이를 StringBuilder에 추가
                }
                // 마지막 공백 제거 후 출력
                System.out.println(result.toString().trim());
            }
        }
    }
