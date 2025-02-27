package com.algorithm2025.backjoon.day05;

import java.util.Scanner;
import java.util.HashMap;

public class Example20250105_re_q2 { //10807 개수세기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> countMap = new HashMap<>();

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int V = sc.nextInt();
        System.out.println(countMap.getOrDefault(V, 0));
    }
}
