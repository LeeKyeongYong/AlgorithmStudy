package com.jababookbackjoon4;

import java.util.Arrays;
import java.util.Scanner;

public class Example20240528_q1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        /**
         * 9
         * 10
         * 1 2 3 4 5 6 7 8 9
         */

        int left = 0;
        int right = arr.length - 1;
        int answer = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == m) {
                answer++;
                right--;
                left++;
            } else if (sum < m) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(answer);
    }
}
