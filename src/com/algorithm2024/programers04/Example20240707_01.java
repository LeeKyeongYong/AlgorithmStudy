package com.algorithm2024.programers04;

public class Example20240707_01 { //가장 긴 팰린드롬

    // Helper method to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
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

    // Method to find the longest palindromic substring
    public static int solution(String s) {
        int answer = 1;
        int len = s.length();

        for (int start = 0; start < len; start++) {
            for (int end = len; end > start; end--) {
                if (isPalindrome(s.substring(start, end))) {
                    answer = Math.max(answer, end - start);
                }
            }
        }

        return answer;
    }

}
