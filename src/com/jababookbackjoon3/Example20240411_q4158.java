package com.jababookbackjoon3;

import java.util.HashMap;
import java.util.Scanner;

public class Example20240411_q4158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if (n == 0 && m == 0) {
                break;
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int answer = 0;
            for (int i = 0; i < m; i++) {
                int num = sc.nextInt();
                if (map.containsKey(num)) {
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }
}
