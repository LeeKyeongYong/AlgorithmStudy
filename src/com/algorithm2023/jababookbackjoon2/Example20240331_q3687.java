package com.algorithm2023.jababookbackjoon2;

import java.util.Arrays;
import java.util.Scanner;

public class Example20240331_q3687 {
    static long[] minis;
    static String[] maxes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        minis = new long[101];
        maxes = new String[101];
        fill();

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(minis[n] + " " + maxes[n]);
        }
    }

    static void fill() {
        Arrays.fill(minis, Long.MAX_VALUE);
        minis[2] = 1;
        minis[3] = 7;
        minis[4] = 4;
        minis[5] = 2;
        minis[6] = 6;
        minis[7] = 8;

        minis[8] = 10;
        minis[9] = 18;
        minis[10] = 22;

        // 2개 ~ 7개 -> 각 숫자

        Long[] add = {1L, 7L, 4L, 2L, 0L, 8L};

        for (int i = 9; i <= 100; i++) {
            for (int j = 2; j <= 7; j++) {
                long temp = minis[i - j] * 10 + add[j - 2];
                minis[i] = Math.min(minis[i], temp);
            }
        }

        maxes[2] = "1";
        maxes[3] = "7";
        maxes[4] = "11";
        maxes[5] = "71";
        maxes[6] = "111";
        maxes[7] = "711";

        for (int i = 8; i <= 100; i++) {
            if (i % 2 == 0) {
                maxes[i] = "1".repeat(i / 2);
            } else {
                maxes[i] = "7" + maxes[i - 3];
            }
        }
    }
}
