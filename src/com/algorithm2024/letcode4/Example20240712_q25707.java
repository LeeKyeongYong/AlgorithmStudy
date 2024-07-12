package com.algorithm2024.letcode4;

import java.util.Arrays;
import java.util.Scanner;

public class Example20240712_q25707 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int sum = Math.abs(arr[0] - arr[arr.length - 1]);
        for (int i = 1; i < arr.length; i++) {
            sum += Math.abs(arr[i - 1] - arr[i]);
        }

        System.out.println(sum);
    }

}
