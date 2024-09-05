package com.algorithm2024.letcode6;

public class Example20240905_q1945_3 {

    public int getLucky(String s, int k) {
        String numericString = "";

        for (char ch : s.toCharArray()) {
            numericString += Integer.toString(ch - 'a' + 1);
        }

        while (k-- > 0) {
            int sum = 0;
            for (char c : numericString.toCharArray()) {
                sum += c - '0';
            }

            numericString = String.valueOf(sum);
        }

        return Integer.parseInt(numericString);
    }

    public static void main(String[] args) {
        Example20240905_q1945_3 sol = new Example20240905_q1945_3();

        System.out.println(sol.getLucky("iiii", 1));
    }

}
