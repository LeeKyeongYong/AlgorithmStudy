package com.algorithm2024.letcode6;

import java.util.Arrays;

public class Example20240918_q1790 {

    public String largestNumber(int[] nums) {
        StringBuilder answer = new StringBuilder();
        String[] str = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            str[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));

        System.out.println(Arrays.toString(str));

        if (str[0].equals("0")) {
            return "0";
        }

        for (String s : str) {
            answer.append(s);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Example20240918_q1790 sol = new Example20240918_q1790();
        System.out.println(sol.largestNumber(new int[]{1, 2, 10, 90, 80}));
    }

}
