package com.algorithm2025.backjoon.day014;

import java.util.Arrays;
import java.util.Collections;

public class Example20250224_Q12933 { //코딩테스트 연습 연습문제 정수 내림차순으로 배치하기

    public long solution(long n) {
        String[] digits = String.valueOf(n).split("");
        Arrays.sort(digits, Collections.reverseOrder());
        return Long.parseLong(String.join("", digits));
    }

    public static void main(String[] args) {
        Example20250224_Q12933 sol = new Example20250224_Q12933();

        System.out.println(sol.solution(118372)); // 873211
    }

}
