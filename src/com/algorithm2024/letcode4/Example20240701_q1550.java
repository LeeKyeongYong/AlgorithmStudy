package com.algorithm2024.letcode4;

public class Example20240701_q1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;

        for (int i : arr) {
            if (i % 2 == 1) {
                count++;
            } else {
                count = 0;
            }

            if (count == 3) {
                return true;
            }
        }

        return false;
    }
}
