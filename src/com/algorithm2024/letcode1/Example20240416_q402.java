package com.algorithm2024.letcode1;

public class Example20240416_q402 {
    public static String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (char c : num.toCharArray()) {
            while (k > 0 && !sb.isEmpty() && sb.charAt(sb.length() - 1) > c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }

            sb.append(c);
        }

        while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // 1219
        System.out.println(removeKdigits("1432219", 3));

        // 200
        System.out.println(removeKdigits("10200", 1));

        // 0
        System.out.println(removeKdigits("10", 2));

        // 0
        System.out.println(removeKdigits("9", 1));

        // 11
        System.out.println(removeKdigits("112", 1));

        // 1
        System.out.println(removeKdigits("10001", 1));
    }
}
