package com.algorithm2024.letcode2;

import java.util.Stack;

public class Example20240503_q38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        int index = 1;
        String given = "1";
        while (index != n) {
            System.out.println(index + " " + given);
            index++;
            given = parse(given);
        }

        return given;
    }

    public String parse(String given) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < given.length(); i++) {
            char c = given.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (stack.peek() != c) {
                // 다른 경우
                int index = 0;
                char target = stack.peek();
                while (!stack.isEmpty()) {
                    stack.pop();
                    index++;
                }
                sb.append(index).append(target);
                stack.push(c);
            } else {
                // 같은 경우
                stack.push(c);
            }
        }

        if (!stack.isEmpty()) {
            char target = stack.peek();
            int index = 0;

            while (!stack.isEmpty()) {
                stack.pop();
                index++;
            }

            sb.append(index).append(target);
        }

        return sb.toString();
    }
}
