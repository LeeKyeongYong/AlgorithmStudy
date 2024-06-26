package com.algorithm2024.letcode3;

public class Example20240626_q28 {
    public int strStr(String haystack, String needle) {
        int answer = -1;

        if(haystack.contains(needle)) {
            answer = haystack.indexOf(needle);
        }

        return answer;
    }
}
