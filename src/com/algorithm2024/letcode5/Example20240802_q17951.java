package com.algorithm2024.letcode5;

import java.util.Scanner;

public class Example20240802_q17951 { //이분탐색 점수 별 그룹 수 나누기 (코테랑 유사)

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int answer = 0;
        int left = 0;
        int right = 0;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            right += arr[i];
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            int groupCount = 0;

            for (int i = 0; i < n; i++) {
                sum += arr[i];

                if (sum >= mid) {
                    groupCount++;
                    sum = 0;
                }
            }

            if (groupCount >= m) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

}
