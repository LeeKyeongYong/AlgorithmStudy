package com.algorithm2024.letcode1;

public class Example20240410_q713 { //슬라이딩 윈도우 (연속된 곲 의 값 미만찾기)
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int sum = 1;
        int answer = 0;

        while (right < nums.length) {
            // 1. 오른쪽으로 가면서 곱한다
            sum *= nums[right];

            // 2. sum이 k 이상이라면 k 미만으로 가기 위해서 left를 올리고 나눠준다.
            while (sum >= k) {
                sum /= nums[left];
                left++;
            }

            // 3. 갯수 계산
            answer += (right - left) + 1;
            right++;
        }

        return answer;
    }
}
