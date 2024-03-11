package com.jababookbackjoon2;

import java.io.*;

public class Exam20240311_q2169 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[][][] dp = new int[n + 1][m + 1][3];
        int[][] arr = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j][0] = Integer.MIN_VALUE;
                dp[i][j][1] = Integer.MIN_VALUE;
                dp[i][j][2] = Integer.MIN_VALUE;
            }
        }

        for (int i = 1; i <= n; i++) {
            inputs = br.readLine().split(" ");

            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(inputs[j - 1]);
            }
        }

        dp[1][1][0] = arr[1][1];
        dp[1][1][1] = arr[1][1];
        dp[1][1][2] = arr[1][1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j > 1) {
                    dp[i][j][0] = Math.max(dp[i][j - 1][0], dp[i][j - 1][1]) + arr[i][j];
                }

                if (i > 1) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][0], Math.max(dp[i - 1][j][1], dp[i - 1][j][2])) + arr[i][j];
                }
            }

            for (int j = m - 1; j >= 1; j--) {
                dp[i][j][2] = Math.max(dp[i][j + 1][1], dp[i][j + 1][2]) + arr[i][j];
            }
        }

        bw.write(Math.max(dp[n][m][0], dp[n][m][1]) + "\n");
        bw.flush();
    }
}
