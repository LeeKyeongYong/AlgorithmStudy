package com.algorithm2024.programers01;

import java.util.HashMap;
import java.util.Map;

public class Example20240331_01 {//단짠
    static int solve(int n, int[] arr) {

        /**
         *  5 -5 6 0 2 -8  -> 일반
         *0 5  0 6 6 8  0  -> 누적합
         */

        Map<Integer, Integer> counter = new HashMap<>();

        int[] prefix = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }

        int answer = 0;
        for (int i = 0; i < prefix.length; i++) {
            int value = prefix[i];

            if (!counter.containsKey(value)) {
                answer += 0;
                counter.put(value, 1);
            } else {
                answer += counter.get(value);
                counter.put(value, counter.getOrDefault(value, 0) + 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 4
        System.out.println(solve(6, new int[]{5, -5, 6, 0, 2, -8}));
    }
}
