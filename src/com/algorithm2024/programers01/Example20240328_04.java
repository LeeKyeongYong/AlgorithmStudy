package com.algorithm2024.programers01;

import java.util.Stack;

public class Example20240328_04 {//괄호변환
    public static String solution(String p) {
        return recursive(p);
    }

    public static String recursive(String s) {
        if (s.isEmpty()) {
            return "";
        }

        int index = catchFirstBalancedIndex(s);
        String u = s.substring(0, index);
        String v = s.substring(index);

        if (isPair(u)) {
            return u + recursive(v);
        } else {
            return "(" + recursive(v) + ")" + popAndReverse(u);
        }
    }

    public static int catchFirstBalancedIndex(String s) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                return left + right;
            }
        }

        return 0;
    }

    public static boolean isPair(String s) {
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static String popAndReverse(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < s.length() - 1; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stringBuilder.append(')');
            } else {
                stringBuilder.append('(');
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        // "(()())()"
        System.out.println(solution("(()())()"));
    }
}
