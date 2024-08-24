package com.algorithm2024.letcode5;

public class Example20240824_q564 {
    public String nearestPalindromic(String n) {
        long number = Long.parseLong(n);

        for (int i = 1; i <= number; i++) {
            String beforeNumber = Long.toString(number - i);
            String afterNumber = Long.toString(number + i);
            boolean isPalindromeBefore = isPalindrome(beforeNumber);
            boolean isPalindromeAfter = isPalindrome(afterNumber);

            if (isPalindromeBefore && isPalindromeAfter) {
                return beforeNumber;
            } else if (isPalindromeBefore) {
                return beforeNumber;
            } else if (isPalindromeAfter) {
                return afterNumber;
            }
        }

        return "";
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            if (l != r) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Example20240824_q564 q = new Example20240824_q564();
        System.out.println(q.nearestPalindromic("807045053224792883"));
    }
}
