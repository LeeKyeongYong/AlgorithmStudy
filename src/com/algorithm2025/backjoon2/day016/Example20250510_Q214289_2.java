package com.algorithm2025.backjoon2.day016;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Example20250510_Q214289_2 { //코딩테스트 연습 2023 현대모비스 알고리즘 경진대회 예선  에어컨

    public int Example20250510_Q214289_2(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        final int INF = 1000 * 100;
        final int OFFSET = 10;

        temperature += OFFSET;
        t1 += OFFSET;
        t2 += OFFSET;

        int len = onboard.length;
        int[][] DP = new int[len][51];
        Arrays.stream(DP).forEach(row -> Arrays.fill(row, INF));
        DP[0][temperature] = 0;

        final int finalT1 = t1;
        final int finalT2 = t2;
        final int finalTemp = temperature;
        final int finalA = a;
        final int finalB = b;

        int flag = (finalTemp > finalT2) ? -1 : 1;

        IntStream.range(1, len).forEach(i -> {
            final int iCopy = i;
            IntStream.range(0, 51).forEach(j -> {
                final int jCopy = j;

                if (onboard[iCopy] == 0 || (finalT1 <= jCopy && jCopy <= finalT2)) {
                    int stay = (jCopy == finalTemp) ? DP[iCopy - 1][jCopy] : INF;

                    int inc = (0 <= jCopy + flag && jCopy + flag <= 50)
                            ? DP[iCopy - 1][jCopy + flag]
                            : INF;

                    int dec = (0 <= jCopy - flag && jCopy - flag <= 50)
                            ? DP[iCopy - 1][jCopy - flag] + finalA
                            : INF;

                    int idle = (finalT1 <= jCopy && jCopy <= finalT2)
                            ? DP[iCopy - 1][jCopy] + finalB
                            : INF;

                    DP[iCopy][jCopy] = IntStream.of(stay, inc, dec, idle).min().orElse(INF);
                }
            });
        });

        return Arrays.stream(DP[len - 1]).min().orElse(INF);
    }
}
