package com.algorithm2024.letcode2;

public class Example20240505_q162 {
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int answer = Integer.MIN_VALUE;
        int indexAnswer = 0;

        while (left <= right) {
            int index = -1;
            int temp = 0;

            if (nums[left] > nums[right]) {
                index = left;
                temp = nums[left];
            } else {
                index = right;
                temp = nums[right];
            }

            if (temp > answer) {
                indexAnswer = index;
                answer = temp;
            }

            left++;
            right--;
        }

        return indexAnswer;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{-2147483648, -2147483647}));
    }
}
