package com.algorithm2024.programers02;

public class Example20240412_2 {//연속된부분수열의 합
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};

        int left = 0;
        int sum = 0;

        int l = 1000000;
        int r = 2000001;

        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];

            while (sum > k) {
                sum -= sequence[left];
                left++;
            }

            if (sum == k) {
                if (Math.abs(l - r) > Math.abs(right - left)) {
                    l = left;
                    r = right;
                }
            }
        }

        return new int[]{l, r};
    }
}
