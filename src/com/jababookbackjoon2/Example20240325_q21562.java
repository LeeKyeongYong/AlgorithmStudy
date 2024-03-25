package com.jababookbackjoon2;

import java.util.Arrays;
import java.util.Scanner;

public class Example20240325_q21562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i]);
        }

        System.out.println(Arrays.toString(dp));
    }
}
