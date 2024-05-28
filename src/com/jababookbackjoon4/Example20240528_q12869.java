package com.jababookbackjoon4;

import java.util.List;
import java.util.Scanner;

public class Example20240528_q12869 {
    static final List<int[]> ATTACK = List.of(
            new int[]{-9, -3, -1},
            new int[]{-9, -1, -3},
            new int[]{-3, -9, -1},
            new int[]{-3, -1, -9},
            new int[]{-1, -3, -9},
            new int[]{-1, -9, -3}
    );

    static int n;
    static int[] arr;
    static int[][][] dp;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        answer = Integer.MAX_VALUE;

        n = sc.nextInt();
        arr = new int[3];
        dp = new int[61][61][61];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        permutation(arr.clone(), 0);
        System.out.println(answer);
    }

    static void permutation(int[] copy, int count) {
        int a1 = copy[0];
        int a2 = copy[1];
        int a3 = copy[2];

        if (count >= answer) {
            return;
        }

        if (dp[a1][a2][a3] != 0 && dp[a1][a2][a3] <= count) {
            return;
        }

        dp[a1][a2][a3] = count;
        if (a1 == 0 && a2 == 0 && a3 == 0) {
            answer = Math.min(answer, count);
        }

        for (int[] i : ATTACK) {
            int[] next = {
                    Math.max(a1 + i[0], 0),
                    Math.max(a2 + i[1], 0),
                    Math.max(a3 + i[2], 0)
            };

            permutation(next, count + 1);
        }
    }
}
