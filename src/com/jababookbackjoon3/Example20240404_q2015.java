package com.jababookbackjoon3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Example20240404_q2015 {
    /**
     * 1, 2, 3 -> 6
     * 1 12 123 2 23 3
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            prefix[i] = prefix[i - 1] + num;
        }

        map.put(0, 1);
        for (int i = 1; i <= n; i++) {
            answer += map.getOrDefault(prefix[i] - k, 0);
            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
        }

        System.out.println(answer);
    }
}
