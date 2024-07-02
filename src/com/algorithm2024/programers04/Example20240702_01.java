package com.algorithm2024.programers04;

import java.util.ArrayList;
import java.util.List;

public class Example20240702_01 {//카운트 다운
    public static List<Integer> solution(int target) {
        // 결과를 저장할 리스트
        List<Integer> answer = new ArrayList<>();

        // 다트의 최소 개수와 최대 개수를 저장할 배열
        int[][] dp = new int[target + 1][2];

        // 배열을 초기화
        for (int i = 0; i <= target; i++) {
            dp[i][0] = Integer.MAX_VALUE; // 최소 개수는 무한대로 초기화
            dp[i][1] = -1; // 최대 개수는 -1로 초기화 (최초 값 없음)
        }

        // 0점은 0개의 다트로 만들 수 있음
        dp[0][0] = 0;
        dp[0][1] = 0;

        for (int i = 1; i <= target; i++) {
            if (i <= 20 || i == 50) {
                dp[i][0] = 1;
                dp[i][1] = 1;
            } else if (i <= 40 && i % 2 == 0) {
                dp[i][0] = 1;
                dp[i][1] = 0;
            } else if (i <= 60 && i % 3 == 0) {
                dp[i][0] = 1;
                dp[i][1] = 0;
            } else if (i >= 51 && i <= 70) {
                dp[i][0] = 2;
                dp[i][1] = 2;
            } else if (i < 70) {
                if (i < 40) {
                    dp[i][0] = 2;
                    dp[i][1] = 2;
                } else {
                    dp[i][0] = 2;
                    dp[i][1] = 1;
                }
            } else {
                if (i >= 60) {
                    if (dp[i - 60][0] == dp[i - 50][0]) {
                        dp[i][0] = dp[i - 50][0] + 1;
                        dp[i][1] = Math.max(dp[i - 60][1], dp[i - 50][1] + 1);
                    } else if (dp[i - 60][0] < dp[i - 50][0]) {
                        dp[i][0] = dp[i - 60][0] + 1;
                        dp[i][1] = dp[i - 60][1];
                    } else {
                        dp[i][0] = dp[i - 50][0] + 1;
                        dp[i][1] = dp[i - 50][1] + 1;
                    }
                }
            }
        }

        // 결과를 리스트에 추가
        answer.add(dp[target][0]);
        answer.add(dp[target][1]);

        return answer;
    }

    public static void main(String[] args) {
        int target = 100; // 예시
        List<Integer> result = solution(target);
        System.out.println("Minimum darts: " + result.get(0));
        System.out.println("Maximum darts: " + result.get(1));
    }
}
