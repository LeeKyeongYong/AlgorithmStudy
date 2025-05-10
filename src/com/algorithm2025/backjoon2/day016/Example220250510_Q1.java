package com.algorithm2025.backjoon2.day016;

import java.util.stream.IntStream;

public class Example220250510_Q1 { //코딩테스트 연습 연습문제  쌍둥이 빌딩 숲

    public static int Example220250510_Q1(int n, int count) {
        long[][] arr = new long[n + 1][n + 2];
        final long MOD = 1_000_000_007;

        arr[1][1] = 1;

        IntStream.rangeClosed(2, n).forEach(x ->
                IntStream.rangeClosed(1, x + 1).forEach(y -> {
                    long temp;

                    if (y == 1) {
                        temp = arr[x - 1][y] * (2L * (x - 1));
                    } else if (y > 1 && y <= x) {
                        temp = arr[x - 1][y] * (2L * (x - 1)) + arr[x - 1][y - 1];
                    } else {
                        temp = arr[x - 1][y - 1];
                    }

                    arr[x][y] = temp % MOD;
                })
        );

        return (int) (arr[n][count] % MOD);
    }

}
