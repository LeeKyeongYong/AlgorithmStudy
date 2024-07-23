package com.algorithm2024.programers04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example20240723_01 { //Summer/Winter Coding(~2018) 스티커 모으기(2)

    private static final int MOD = (int)1e9 + 7;

    // 이진 검색 함수
    private static int binarySearch(long[] arr, long x) {
        int idx = Arrays.binarySearch(arr, x);
        return idx >= 0 ? idx : -1;
    }

    private static int solve(int[] b) {
        int n = b.length;
        long[] ps = new long[n + 1];

        // 부분합 계산
        ps[0] = 0;
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + b[i];
        }

        // maxe 계산
        long sum = ps[n];
        int maxe = (int) Math.ceil(Math.log(sum) / Math.log(2));

        // DP 테이블 초기화
        long[][] dp = new long[n][maxe + 1];
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Arrays.stream(dp[i - 1]).sum() % MOD;

            for (int e = 1; e <= maxe; e++) {
                if (dp[i][e - 1] == 0) {
                    continue;
                }

                // jhalf 찾기
                long target = ps[i + 1] - b[i] * (1L << (e - 1));
                int jhalf = binarySearch(ps, target);

                if (jhalf == -1) {
                    continue;
                }

                double eprime = Math.log(b[i] / (double) b[jhalf - 1]) / Math.log(2) + (e - 1);
                if (eprime < 0 || eprime % 1 != 0) {
                    continue;
                }

                int eprimeInt = (int) eprime;
                if (jhalf > 0 && (eprimeInt >= dp[0].length || dp[jhalf - 1][eprimeInt] == 0)) {
                    continue;
                }

                // jfull 찾기
                target = ps[i + 1] - b[i] * (1L << e);
                int jfull = binarySearch(ps, target);

                if (jfull == -1) {
                    continue;
                }

                if (jfull == 0) {
                    dp[i][e] = 1;
                } else {
                    dp[i][e] = (jfull > 0 ? Arrays.stream(dp[jfull - 1]).sum() : 0) % MOD;
                }
            }
        }

        return (int) (Arrays.stream(dp[n - 1]).sum() % MOD);
    }

    public static int[] solution(int[] a, int[] s) {
        List<Integer> results = new ArrayList<>();

        int start = 0;
        for (int length : s) {
            int[] b = Arrays.copyOfRange(a, start, start + length);
            results.add(solve(b));
            start += length;
        }

        return results.stream().mapToInt(i -> i).toArray();
    }

}
