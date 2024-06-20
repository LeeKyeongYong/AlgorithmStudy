package com.algorithm2024.letcode3;

import java.util.Arrays;

public class Example20240620_q1552 {

    public int maxDistance(int[] position, int m) {
        int answer = 0;
        Arrays.sort(position);

        int left = 1;
        int right = (int) Math.ceil(position[position.length - 1] / (m - 1.0));

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canBallProfits(mid, position, m)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private boolean canBallProfits(int mid, int[] position, int m) {
        int beforePosition = position[0];
        int count = 1;

        for (int i = 1; i < position.length && count < m; ++i) {
            int nowPosition = position[i];

            // 기준 값을 넘어야함
            if (nowPosition - beforePosition >= mid) {
                count += 1;
                beforePosition = nowPosition;
            }
        }

        return count == m;
    }

}
