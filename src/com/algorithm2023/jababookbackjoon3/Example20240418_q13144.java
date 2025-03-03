package com.algorithm2023.jababookbackjoon3;

import java.util.Scanner;

public class Example20240418_q13144 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] visited = new boolean[100001];
        int left = 0;
        int right = 0;
        int count = 0;
        long answer = 0;

        while (left <= n && right <= n) {
            int value = arr[right];

            if (!visited[value]) {
                visited[value] = true;
                right++;
                count++;
                continue;
            }

            if (visited[value]) {
                for (int i = right - left; i >= 1; i--) {
                    answer += i;
                }

                visited[arr[left]] = false;
                count = 0;
                left++;
            }
        }

        System.out.println(right + " " + left + " " + count);
        System.out.println(answer);
    }
}
