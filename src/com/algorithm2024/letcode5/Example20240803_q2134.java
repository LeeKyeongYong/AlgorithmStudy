package com.algorithm2024.letcode5;

public class Example20240803_q2134 {

    public static int minSwaps(int[] nums) {

        int answer = Integer.MAX_VALUE;
        int windowSize = 0;
        int zeroCount = 0;

        for (int num : nums) {
            if (num == 1) {
                windowSize++;
            }
        }

        // 1. 윈도우 초기 0값 계산 (추후 비교를 위해)
        for (int i = 0; i < windowSize; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
        }

        // 2. 슬라이딩 윈도우
        for (int start = 1; start < nums.length; start++) {
            int end = (start + windowSize - 1) % nums.length;

            // 이전 마지막 0 제거
            if (nums[start - 1] == 0) {
                zeroCount--;
            }

            // 이번 마지막 0이면 추가
            if (nums[end] == 0) {
                zeroCount++;
            }

            // 0의 개수 갱신
            answer = Math.min(answer, zeroCount);
        }

        return answer;
    }

    public static void main(String[] args) {
        // 1
        System.out.println(minSwaps(new int[]{0, 1, 0, 1, 1, 0, 0}));
    }

}
