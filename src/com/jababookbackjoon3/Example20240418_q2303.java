package com.jababookbackjoon3;

import java.util.Arrays;
import java.util.Scanner;

public class Example20240418_q2303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int left = 0;
        int right = 0;
        int answer = Integer.MAX_VALUE;

        while (left <= right && right < n) {
            int sum = arr[right] - arr[left];

            if (sum >= m) {
                answer = Math.min(answer, sum);
                left++;
            } else {
                right++;
            }
        }

        System.out.println(answer);
    }
}
