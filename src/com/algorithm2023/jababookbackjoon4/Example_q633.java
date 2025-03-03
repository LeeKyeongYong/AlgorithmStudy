package com.algorithm2023.jababookbackjoon4;

public class Example_q633 {
    public static boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            double j = Math.sqrt(c - (i * i));

            if (j == j) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // true
        System.out.println(judgeSquareSum(4));
    }
}
