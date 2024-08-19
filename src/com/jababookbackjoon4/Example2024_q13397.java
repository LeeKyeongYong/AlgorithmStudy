package com.jababookbackjoon4;

import java.util.Scanner;

public class Example2024_q13397 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        int left = 0;
        int right = 0;
        int answer = right;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            right = Math.max(arr[i], right);
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            int section = 1;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);

                // [최대 - 최소] 값이 mid보다 큰 경우 구간을 늘려준다
                if (max - min > mid) {
                    section++;
                    max = arr[i];
                    min = arr[i];
                }
            }

            if (section <= m) {
                // 구한 구간이 같거나 적으면 더 줄일 여지가 있으므로 범위를 낮춰봄
                answer = mid;
                right = mid - 1;
            } else {
                // 구간 초과시 수를 더 크게 해야함
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
