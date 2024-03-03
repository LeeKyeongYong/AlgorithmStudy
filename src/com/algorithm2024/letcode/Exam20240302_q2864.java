package com.algorithm2024.letcode;

public class Exam20240302_q2864 {
    public String maximumOddBinaryNumber(String s) {
        /**
         * 11100
         * 11001
         * O(n)
         */

        int oneFrequency = 0;
        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            oneFrequency += c - '0';
        }

        for (int i = 0; i < oneFrequency - 1; i++) {
            answer.append("1");
        }

        for (int i = 0; i < s.length() - oneFrequency; i++) {
            answer.append("0");
        }

        answer.append("1");
        return answer.toString();
    }
}
