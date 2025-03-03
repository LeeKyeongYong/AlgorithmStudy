package com.algorithm2023.jababookbackjoon4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example20240807_q1508 {

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                list.add(sum);
            }
        }

        int mod = (int) 1e9 + 7;
        Collections.sort(list);

        int answer = 0;
        for (int i = left - 1; i <= right - 1; i++) {
            answer = (answer + list.get(i)) % mod;
        }

        return answer;
    }

    public static void main(String[] args) {
        Example20240807_q1508 sol = new Example20240807_q1508();

        // 50
        System.out.println(sol.rangeSum(
                new int[]{1, 2, 3, 4},
                4,
                1,
                10
        ));
    }

}
