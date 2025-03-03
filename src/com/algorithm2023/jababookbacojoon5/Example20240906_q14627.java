package com.algorithm2023.jababookbacojoon5;

import java.util.Scanner;

public class Example20240906_q14627 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 파 길이
        int m = sc.nextInt(); // 치킨 수

        int[] arr = new int[n];
        long right = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            right = Math.max(right, arr[i]);
            sum += arr[i];
        }

        long left = 1;
        long length = 0;

        while (left <= right) {
            long mid = (left + right) / 2; // 파 길이
            long count = 0;

            for (int i = 0; i < n; i++) {
                count += arr[i] / mid;
            }

            if (count < m) {
                right = mid - 1;
            } else {
                length = mid;
                left = mid + 1;
            }
        }

        System.out.println(sum - (m * length));
    }
}
