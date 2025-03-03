package com.algorithm2023.jababookbackjoon2;

import java.util.Scanner;

public class Example_20240310_q2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        if (n % 2 == 1) {
            System.out.println(0);
            return;
        }

        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-2] * 3;

            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
            }
        }

        System.out.println(dp[n]);
    }
}
