package com.algorithm2024.letcode3;

import java.util.*;

public class Example20240614_q10025 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[1000001];

        for (int i = 0; i < n; i++) {
            int g = sc.nextInt();
            int pos = sc.nextInt();

            arr[pos] = g;
        }

        int sum = 0;
        int answer = 0;
        int d = 1 + (2 * k);

        for (int i = 0; i <= 1000000; i++) {
            if (i >= d) {
                sum -= arr[i - d];
            }

            sum += arr[i];
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }

}
