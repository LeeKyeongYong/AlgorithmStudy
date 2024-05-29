package com.algorithm2024.programers03;

import java.util.Arrays;

public class Example20240529_02_1 { //코딩테스트 연습 문제 동적계획법(Dynamic Programming)의 도둑질

    public static int solution(int[] money) {

        if (money.length == 0) return 0;
        if (money.length == 1) return money[0];

        // 첫 집을 터는 경우
        int[] dp1 = new int[money.length];
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);

        for (int i = 2; i < money.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], money[i] + dp1[i - 2]);
        }

        // 마지막 집을 터는 경우
        int[] dp2 = new int[money.length];
        dp2[0] = 0;
        dp2[1] = money[1];

        for (int i = 2; i < money.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], money[i] + dp2[i - 2]);
        }

        int maxDp1 = Arrays.stream(dp1).limit(money.length - 1).max().orElse(0);
        int maxDp2 = Arrays.stream(dp2).max().orElse(0);

        return Math.max(maxDp1, maxDp2);
    }

    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1};
        System.out.println(solution(money));  // Example usage
    }
}
