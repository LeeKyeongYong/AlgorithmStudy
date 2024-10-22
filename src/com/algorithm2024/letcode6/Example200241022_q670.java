package com.algorithm2024.letcode6;

public class Example200241022_q670 {
    public int maximumSwap(int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));

        boolean isDone = false;
        for (int i = 0; i < sb.length() - 1; i++) {
            int a = sb.charAt(i) - '0';

            int max = a;
            int index = 0;
            for (int j = i + 1; j < sb.length(); j++) {
                if (max <= sb.charAt(j) - '0' && sb.charAt(j) - '0' != a) {
                    max = sb.charAt(j) - '0';
                    index = j;
                    isDone = true;
                }
            }

            if (isDone) {
                sb.replace(i, i + 1, String.valueOf(max));
                sb.replace(index, index + 1, String.valueOf(a));
                break;
            }
        }

        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        Example200241022_q670 sol = new Example200241022_q670();

        // 7236
        System.out.println(sol.maximumSwap(2736));

        // 98863
        System.out.println(sol.maximumSwap(98368));

        // 9913
        System.out.println(sol.maximumSwap(1993));
    }
}
