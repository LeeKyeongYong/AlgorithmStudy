package com.algorithm2024.letcode1;

public class Example20240417_q42 {

    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = height[0];
        right[n - 1] = height[n - 1];
        for (int i = 1; i < left.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(right[i], left[i]);
            sum += min - height[i];
        }

        return sum;
    }
}
