package com.jababookbackjoon3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example20240403_q11066 {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int[][] dp = new int[n + 1][n + 1];
        int[] sum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + list.get(i - 1);
        }

        for (int i = 2; i <= n; i++) {

            for (int j = 0; j < n; j++) {
                int end = j + i - 1;

                if (end >= n) {
                    continue;
                }

                dp[j][end] = Integer.MAX_VALUE;
                for (int now = j; now < end; now++) {
                    dp[j][end] = Math.min(dp[j][end], dp[j][now] + dp[now + 1][end] + sum[end + 1] - sum[j]);
                }
            }
        }

        System.out.println(dp[0][n - 1]);
    }
}
