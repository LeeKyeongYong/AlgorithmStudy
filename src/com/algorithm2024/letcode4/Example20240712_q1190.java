package com.algorithm2024.letcode4;

import java.util.Stack;

public class Example20240712_q1190 {

    public static String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(sb.length());
            } else if (c == ')') {
                int start = stack.pop();
                int end = sb.length() - 1;

                while (start < end) {
                    char temp = sb.charAt(start);
                    sb.setCharAt(start++, sb.charAt(end));
                    sb.setCharAt(end--, temp);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // dcba
        System.out.println(reverseParentheses("(abcd)"));

        // iloveu
        System.out.println(reverseParentheses("(u(love)i)"));
    }

}
