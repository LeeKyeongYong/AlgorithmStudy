package com.algorithm2024.letcode1;

public class Example20240430_q2997 {
    public static int minOperations(int[] nums, int k) {
        int temp = 0;

        for (int n : nums) {
            temp ^= n;
        }

        temp = temp ^ k;
        int answer = 0;

        while (temp > 0) {
            if ((temp & 1) != 0) {
                answer++;
            }

            temp = temp >> 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        // 2
//        System.out.println(minOperations(new int[]{2, 1, 3, 4}, 1));

        // 0
        System.out.println(minOperations(new int[]{2, 0, 2, 0}, 0));
    }
}
