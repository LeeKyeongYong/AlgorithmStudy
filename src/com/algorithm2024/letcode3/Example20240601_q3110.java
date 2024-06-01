package com.algorithm2024.letcode3;

public class Example20240601_q3110 {

    public int scoreOfString(String s) {
        int answer = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            answer += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }

        return answer;
    }
}
