package com.algorithm2024.letcode2;

import java.util.Stack;

public class Example20240503_q22 {
    static int m;
    static List<String> result;

    public static List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        m = n * 2;
        permutation(1, "(");
        return result;
    }

    static void permutation(int index, String sum) {
        if (index == m) {
            if (isPair(sum)) {
                result.add(sum);
            }
            return;
        }

        permutation(index + 1, sum + "(");
        permutation(index + 1, sum + ")");
    }

    private static boolean isPair(final String sum) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < sum.length(); i++) {
            char c = sum.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (stack.peek() == '(' && c == ')') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        //          [((())), (()()), (())(), ()(()), ()()()]
        // Output: ["((()))","(()())","(())()","()(())","()()()"]
        System.out.println(generateParenthesis(3));
    }
}
