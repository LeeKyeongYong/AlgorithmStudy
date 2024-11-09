package com.algorithm2024.javabookbacjoon6;

import java.util.Scanner;

public class Example20241109_q16493 {

    static int n;
    static int m;
    static int[][] arr;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            arr[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }

        permutation(0, 0, 0);
        System.out.println(answer);
    }

    static void permutation(int start, int sum, int day) {
        if (day > n) {
            return;
        }

        answer = Math.max(answer, sum);

        for (int i = start; i < m; i++) {
            day += arr[i][0];
            sum += arr[i][1];
            permutation(i + 1, sum, day);
            day -= arr[i][0];
            sum -= arr[i][1];
        }
    }

}
