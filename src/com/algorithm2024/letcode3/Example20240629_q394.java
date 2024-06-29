package com.algorithm2024.letcode3;

import java.util.Stack;

public class Example20240629_q394 {

    public static String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        StringBuilder count = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count.append(c);
                continue;
            }

            if (c == '[') {
                numberStack.push(Integer.parseInt(count.toString()));
                stringStack.push(currentString.toString());
                currentString = new StringBuilder();
                count = new StringBuilder();
                continue;
            }

            if (Character.isAlphabetic(c)) {
                currentString.append(c);
                continue;
            }

            if (c == ']') {
                Integer repeatCount = numberStack.pop();
                StringBuilder temp = new StringBuilder(stringStack.pop());
                temp.append(String.valueOf(currentString).repeat(Math.max(0, repeatCount)));
                currentString = temp;
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        // Output: "accaccacc"
        System.out.println(decodeString("3[a2[c]]"));
    }

}
