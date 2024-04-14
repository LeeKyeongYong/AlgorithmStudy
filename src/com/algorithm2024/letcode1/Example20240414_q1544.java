package com.algorithm2024.letcode1;

import java.util.Stack;

public class Example20240414_q1544 {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);

        int gap = Math.abs('A' - 'a');

        while (true) {
            boolean triger = true;

            for (int i = 0; i < sb.length() - 1; i++) {
                char a = sb.charAt(i);
                char b = sb.charAt(i + 1);
                int diff = Math.abs(a - b);

                if (diff == gap) {
                    triger = false;
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                }
            }

            if (triger) {
                break;
            }
        }

        return sb.toString();
    }

    public String makeGood_stack(String s) {
        int gap = Math.abs('A' - 'a');
        Stack<Character> stack = new Stack<>();

        for (char now : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(now);
                continue;
            }

            Character before = stack.peek();
            if (Math.abs(now - before) == gap) {
                stack.pop();
            } else {
                stack.push(now);
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.insert(0, stack.pop());
        }

        return answer.toString();
    }
}
