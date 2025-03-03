package com.algorithm2023.jababookbackjoon4;

import java.util.Scanner;

public class Example20240807_q12847 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }

        long answer = sum;
        for (int i = 1; i < arr.length - m; i++) {
            sum = 0;

            for (int j = i; j < i + m; j++) {
                sum += arr[j];
            }

            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }

}
