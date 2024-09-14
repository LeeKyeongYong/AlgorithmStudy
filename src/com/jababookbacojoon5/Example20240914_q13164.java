package com.jababookbacojoon5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Example20240914_q13164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 1; i < arr.length; i++) {
            pq.add(arr[i] - arr[i - 1]);
        }

        // 1 3 5 6 10
        //   2 2 1 4
        //   1 2 2 4

        int answer = 0;
        while (k - 1 > 0) {
            k--;
            pq.poll();
        }

        while(!pq.isEmpty()) {
            answer += pq.poll();
        }

        System.out.println(answer);
    }
}
