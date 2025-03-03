package com.algorithm2023.jababookbackjoon3;

import java.util.Scanner;

public class Example20240418_q2330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;

        while (left <= n && right <= n) {
            if (sum < target) {
                sum += arr[right];
                right++;
            } else if (sum == target) {
                count++;
                sum -= arr[left];
                left++;
            } else {
                sum -= arr[left];
                left++;
            }
        }

        System.out.println(count);
    }
}
