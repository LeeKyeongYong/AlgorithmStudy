package com.algorithm2024.letcode1;

public class Example20240409_q41 {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n + 1];

        for (int i : nums) {
            if (i > 0 && i <= n) {
                visited[i] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return i;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}
