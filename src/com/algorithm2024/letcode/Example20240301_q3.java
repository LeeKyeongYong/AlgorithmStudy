package com.algorithm2024.letcode;

import java.util.HashSet;
import java.util.Set;

public class Example20240301_q3 {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;

        Set<Character> alphabet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char now = s.charAt(right);

            if (alphabet.contains(now)) {
                while (alphabet.contains(now)) {
                    alphabet.remove(s.charAt(left));
                    left++;
                }
                alphabet.add(now);
            } else {
                alphabet.add(now);
                answer = Math.max(answer, right - left + 1);
            }


            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Example20240301_q3 sol = new Example20240301_q3();

        // 1
        System.out.println(sol.lengthOfLongestSubstring(" "));
    }
}
