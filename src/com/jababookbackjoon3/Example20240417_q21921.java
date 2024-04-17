package com.jababookbackjoon3;

import java.util.HashMap;
import java.util.Scanner;

public class Example20240417_q21921 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] arr = new int[n];
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] += arr[i] + prefix[i - 1];
        }

        int answer = 0;

        for (int i = x; i < prefix.length; i++) {
            int sum = prefix[i] - prefix[i - x];

            answer = Math.max(answer, sum);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        if (answer == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(answer);
            System.out.println(map.get(answer));
        }
    }
}
