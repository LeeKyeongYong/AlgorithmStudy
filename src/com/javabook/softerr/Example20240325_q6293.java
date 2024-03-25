package com.javabook.softerr;

import java.util.Scanner;

public class Example20240325_q6293 {
    // 최장증가수열 or 이분탐색

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = -1;
        for (int i : dp) {
            max = Math.max(max, i);
        }

        System.out.println(max);
    }
}
