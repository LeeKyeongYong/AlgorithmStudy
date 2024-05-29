package com.algorithm2024.programers03;

import java.util.Arrays;

public class Example20240529_06 { //프로그래머스 현대 모비스? 에어콘 문제
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        final int k = 1000 * 100;
        t1 += 10;
        t2 += 10;
        temperature += 10;

        int[][] DP = new int[onboard.length][51];
        for (int[] row : DP) {
            Arrays.fill(row, k);
        }

        DP[0][temperature] = 0;

        int flag = (temperature > t2) ? -1 : 1;

        for (int i = 1; i < onboard.length; i++) {
            for (int j = 0; j < 51; j++) {
                if ((onboard[i] == 1 && t1 <= j && j <= t2) || onboard[i] == 0) {
                    int minV = k;

                    if (0 <= j + flag && j + flag <= 50) {
                        minV = Math.min(minV, DP[i - 1][j + flag]);
                    }

                    if (j == temperature) {
                        minV = Math.min(minV, DP[i - 1][j]);
                    }

                    if (0 <= j - flag && j - flag <= 50) {
                        minV = Math.min(minV, DP[i - 1][j - flag] + a);
                    }

                    if (t1 <= j && j <= t2) {
                        minV = Math.min(minV, DP[i - 1][j] + b);
                    }

                    DP[i][j] = minV;
                }
            }
        }

        return Arrays.stream(DP[onboard.length - 1]).min().orElse(k);
    }

    public static void main(String[] args) {
        Example20240529_06 sol = new Example20240529_06();
        int temperature = 5;
        int t1 = 1;
        int t2 = 10;
        int a = 2;
        int b = 3;
        int[] onboard = {1, 0, 0, 1, 1, 0, 1};

        System.out.println(sol.solution(temperature, t1, t2, a, b, onboard)); // Example usage
    }
}
