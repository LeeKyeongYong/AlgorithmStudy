package com.jababookbackjoon3;

import java.util.Scanner;

public class Example20240405_q16987 {
    static int n;
    static int[][] egg;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        egg = new int[n][2];
        visited = new boolean[n];
        answer = 0;

        for (int i = 0; i < n; i++) {
            egg[i][0] = sc.nextInt(); // 내구도
            egg[i][1] = sc.nextInt(); // 무게
        }

        // 내구도 -= 상대 계란 무게 ->

        permutation(0, 0);
        System.out.println(answer);
    }

    static void permutation(int index, int count) {
        if (index == n - 1 || count == n) {
            answer = Math.max(answer, count);
            return;
        }

        if (egg[index][0] <= 0) {
            permutation(index + 1, count);
        } else {
            for (int i = 0; i < n; i++) {
                if (i == index) {
                    continue;
                }

                if (egg[i][0] > 0) {
                    egg[i][0] -= egg[index][1];
                    egg[index][0] -= egg[index][1];
                    int add = egg[i][0] <= 0 ? 1 : 0;
                    int add2 = egg[index][0] <= 0 ? 1 : 0;
                    permutation(index + 1, count + add + add2);
                    egg[i][0] += egg[index][1];
                    egg[index][0] += egg[index][1];
                }
            }
        }
    }
}
