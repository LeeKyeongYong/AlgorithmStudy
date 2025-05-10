package com.algorithm2025.backjoon2.day016;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Example20250510_Q214289 { //코딩테스트 연습 2023 현대모비스 알고리즘 경진대회 예선  에어컨

    public int Example20250510_Q214289(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        final int INF = 1000 * 100;
        final int OFFSET = 10;

        temperature += OFFSET;
        t1 += OFFSET;
        t2 += OFFSET;

        int len = onboard.length;
        int[][] DP = new int[len][51];
        Arrays.stream(DP).forEach(row -> Arrays.fill(row, INF));
        DP[0][temperature] = 0;

        int flag = (temperature > t2) ? -1 : 1;

        IntStream.range(1, len).forEach(i ->
                IntStream.range(0, 51).forEach(j -> {
                    if (onboard[i] == 0 || (t1 <= j && j <= t2)) {
                        int finalJ = j;

                        int stay = (j == temperature) ? DP[i - 1][j] : INF;

                        int inc = (0 <= finalJ + flag && finalJ + flag <= 50)
                                ? DP[i - 1][j + flag]
                                : INF;

                        int dec = (0 <= finalJ - flag && finalJ - flag <= 50)
                                ? DP[i - 1][j - flag] + a
                                : INF;

                        int idle = (t1 <= j && j <= t2)
                                ? DP[i - 1][j] + b
                                : INF;

                        DP[i][j] = IntStream.of(stay, inc, dec, idle)
                                .min()
                                .orElse(INF);
                    }
                })
        );

        return Arrays.stream(DP[len - 1]).min().orElse(INF);
    }
}
