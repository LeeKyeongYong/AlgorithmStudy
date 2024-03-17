package com.algorithm2024.letcode;

public class Example20240317_q34 {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[2];

        int d = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                d++;
            }
        }

        if (d == 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;

        int indexA = 0;
        int indexB = 0;

        // 왼쪽 범위의 수를 구하기
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                indexA = mid;
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = 0;
        right = nums.length - 1;

        // 오른쪽 범위의 수를 구하기
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                indexB = mid;
                left = mid + 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        answer[0] = indexA;
        answer[1] = indexB;

        return answer;
    }
}
