package com.algorithm2024.letcode7;

import java.util.Stack;

public class Example20241108_q1957 {
    public String makeFancyString(String s) {
        Stack<Character> stack = new Stack<>();

        char before = '-';
        int remain = 0;

        for (char c : s.toCharArray()) {
            if (before == c && remain == 2) {
                continue;
            }

            if (c == before) {
                remain++;
                stack.push(c);
                continue;
            }

            if (before != c) {
                stack.push(c);
                before = c;
                remain = 1;
            } else {
                remain++;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
