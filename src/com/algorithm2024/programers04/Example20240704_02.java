package com.algorithm2024.programers04;

import java.util.HashSet;
import java.util.Set;

public class Example20240704_02 { //동적계획법(Dynamic Programming) N으로 표현

    public int solution(int N, int number) {
        // DP 테이블 초기화
        Set<Integer>[] dp = new HashSet[9];
        for (int i = 1; i < 9; i++) {
            dp[i] = new HashSet<>();
        }

        // 숫자를 N으로만 구성한 초기값 설정
        for (int i = 1; i < 9; i++) {
            dp[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        // DP 테이블 업데이트
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (int num1 : dp[j]) {
                    for (int num2 : dp[i - j]) {
                        dp[i].add(num1 + num2);
                        dp[i].add(num1 - num2);
                        dp[i].add(num1 * num2);
                        if (num2 != 0 && num1 % num2 == 0) {
                            dp[i].add(num1 / num2);
                        }
                    }
                }
            }
            // 목표 숫자를 찾은 경우
            if (dp[i].contains(number)) {
                return i;
            }
        }

        // 8보다 큰 경우
        return -1;
    }

}
