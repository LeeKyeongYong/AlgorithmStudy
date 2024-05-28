package com.jababookbackjoon4;

import java.util.Scanner;

public class Example20240528_q10709 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            map[i] = str.toCharArray();
        }

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
                if (map[i][j] == '.') {
                    int distance = Integer.MAX_VALUE;

                    for (int k = 0; k < j; k++) {
                        if (map[i][k] == 'c') {
                            distance = Math.min(distance, j - k);
                        }
                    }

                    if (distance != Integer.MAX_VALUE) {
                        dp[i][j] = distance;
                    }

                } else if (map[i][j] == 'c') {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
