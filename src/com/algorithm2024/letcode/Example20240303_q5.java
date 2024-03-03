package com.algorithm2024.letcode;

public class Example20240303_q5 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLength = 1;
        String answer = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + maxLength; j <= s.length(); j++) {
                String substring = s.substring(i, j);

                if (isPallindrome(substring) && j - i > maxLength) {
                    maxLength = j - i;
                    answer = substring;
                }
            }
        }

        return answer;
    }

    private boolean isPallindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
