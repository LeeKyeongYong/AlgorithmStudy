package com.algorithm2024.letcode6;

import java.util.HashSet;

public class Example20240928_q3043 {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int answer = 0;
        HashSet<Integer> arr1Prefix = new HashSet<Integer>();

        for (int a1 : arr1) {
            while (!arr1Prefix.contains(a1) && a1 > 0) {
                arr1Prefix.add(a1);
                a1 /= 10;
            }
        }

        for (int a2 : arr2) {
            while (!arr1Prefix.contains(a2) && a2 > 0) {
                a2 /= 10;
            }

            if (a2 > 0) {
                answer = Math.max(answer, (int) Math.log10(a2) + 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Example20240928_q3043 sol = new Example20240928_q3043();

        // 3
        System.out.println(sol.longestCommonPrefix(
                new int[]{1, 10, 100},
                new int[]{1000}
        ));
    }

}
