
package com.jababookbackjoon3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Example20240406_q2565 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[i][1] > arr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int asInt = Arrays.stream(dp).max().getAsInt();
        System.out.println(n - asInt);
    }
}
