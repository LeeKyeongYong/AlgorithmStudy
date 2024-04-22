package com.jababookbackjoon3;

import java.util.Arrays;
import java.util.Scanner;

public class Example20240422_q3151 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long answer = 0;
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int target = arr[i];

            int l = i + 1;
            int r = arr.length - 1;

            while (l < r) {
                int mid = arr[l] + arr[r];

                int sum = target + mid;
                if (sum == 0) {
                    answer++;
                }

                if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        System.out.println(answer);
    }
}
