package com.algorithm2023.jababookbacojoon5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Example20240914_q2212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        // 1 3 6 6 7 9
        //   2 3 0 1 2

        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i < n; i++) {
            pq.add(arr[i] - arr[i - 1]);
        }

        // 구간 수 (k - 1)
        while (k - 1 > 0) {
            k--;
            pq.poll();
        }

        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        System.out.println(answer);
    }
}
