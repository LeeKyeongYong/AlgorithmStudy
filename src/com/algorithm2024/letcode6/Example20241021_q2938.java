package com.algorithm2024.letcode6;

public class Example20241021_q2938 {

    public long minimumSteps(String s) {
        // 11100
        long whiteCount = 0;
        long answer = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                whiteCount++;
            } else {
                answer += whiteCount;
            }
        }

        return answer;
    }

}
