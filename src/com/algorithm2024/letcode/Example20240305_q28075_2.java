package com.algorithm2024.letcode;

import java.util.Scanner;

public class Example20240305_q28075_2 {
    static int n;
    static int m;
    static int[][] arr;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[2][3];
        answer = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        permutation(0, 0, -1);
        System.out.println(answer);
    }

    static void permutation(int index, int sum, int beforeCol) {
        if (index == n) {
            if (sum >= m) {
                answer++;
            }

            return;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                int score = 0;

                if (beforeCol == j) {
                    score += (arr[i][j] / 2);
                } else {
                    score = arr[i][j];
                }

                permutation(index + 1, sum + score, j);
            }
        }
    }
}
