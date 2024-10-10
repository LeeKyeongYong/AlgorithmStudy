package com.algorithm2024.letcode6;

import java.util.Stack;

public class Example20241010_q1963 {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack();

        int unPair = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    unPair++;
                }
            }
        }
        return (unPair + 1) / 2;
    }
}
