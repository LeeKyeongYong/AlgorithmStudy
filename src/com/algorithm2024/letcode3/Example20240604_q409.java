package com.algorithm2024.letcode3;

import java.util.HashMap;
import java.util.Map;

public class Example20240604_q409 {

    public int longestPalindrome(String s) {
        Map<Character, Integer> counts = new HashMap<>();

        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean hasOdd = false;

        for (int count : counts.values()) {
            length += (count / 2) * 2;
            if (count % 2 == 1) {
                hasOdd = true;
            }
        }

        if (hasOdd) {
            length += 1;
        }

        return length;
    }
}
