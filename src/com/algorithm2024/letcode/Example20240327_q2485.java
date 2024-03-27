package com.algorithm2024.letcode;

public class Example20240327_q2485 {
    public static int pivotInteger(int n) {
        int[] prefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + i;
        }

        for (int i = 1; i <= n; i++) {
            int pivot = i;

            if (prefix[pivot] == prefix[n] - prefix[pivot - 1]) {
                return pivot;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
    }
}
