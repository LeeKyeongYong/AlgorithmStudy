package com.algorithm2023.jababookbackjoon4;

import java.util.Arrays;
import java.util.Scanner;

public class Example20240507_q13702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        long left = 1;
        long right = arr[arr.length - 1];

        while (left <= right) {
            long mid = (left + right) / 2;
            int temp = 0;

            for (int i = 0; i < n; i++) {
                temp += arr[i] / mid;
            }

            if (temp >= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
