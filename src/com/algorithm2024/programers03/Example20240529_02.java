package com.algorithm2024.programers03;

import java.util.Arrays;

public class Example20240529_02 { //코딩테스트 연습 문제 동적계획법(Dynamic Programming)의 도둑질

    public static int solution(int[] money) {
        int answer=0;
        int[] dp1 = new int[money.length];
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);

        for (int i = 2; i < money.length-1; i++) { // 첫 집을 무조건 터는 경우
            dp1[i] = Math.max(dp1[i-1], money[i]+dp1[i-2]);
        }

        int[] dp2 = new int[money.length];
        dp2[0] = 0;
        dp2[1] = money[1];

        for (int i = 2; i < money.length; i++) { // 마지막 집을 무조건 터는 경우
            dp2[i] = Math.max(dp2[i-1], money[i]+dp2[i-2]);
        }
        answer=Math.max(Arrays.stream(dp1).max().getAsInt(), Arrays.stream(dp2).max().getAsInt());
        return answer; // 두 경우 중 최대
    }

    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1};
        System.out.println(solution(money));  // Example usage
    }
}
