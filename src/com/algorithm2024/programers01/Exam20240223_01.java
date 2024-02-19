package com.algorithm2024.programers01;


//프로그래머스 연습문제 거스름돈
public class Exam20240223_01 { //동적 계획법 활용한것

    public static void main(String[] args) {
        int n = 5;
        int[] money = {1, 2, 5};
        Solution004 s4=new Solution004();
        int result = s4.solution(n, money);
        System.out.println(result);
    }
}
class Solution004 {
    public static int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int coin : money) {
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin];
                dp[i] %= 1000000007;
            }
        }

        return dp[n];
    }
    /*

     public static int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        Arrays.stream(money).forEach(coin ->
                IntStream.rangeClosed(coin, n)
                        .forEach(i -> {
                            dp[i] += dp[i - coin];
                            dp[i] %= 1000000007;
                        }));

        return dp[n];
    }

     */
}