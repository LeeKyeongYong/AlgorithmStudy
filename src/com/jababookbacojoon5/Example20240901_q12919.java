package com.jababookbacojoon5;

import java.util.Scanner;

public class Example20240901_q12919 {
    static String start;
    static boolean answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        start = sc.next();
        StringBuilder end = new StringBuilder(sc.next());
        permutation(start, end);
        System.out.println(answer ? 1 : 0);
    }

    static void permutation(String start, StringBuilder end) {
        if (end.length() == start.length()) {
            if (end.toString().equals(start)) {
                answer = true;
            }
            return;
        }

        if (end.toString().startsWith("B")) {
            end.deleteCharAt(0);
            end.reverse();
            permutation(start, end);
            end.reverse();
            end.insert(0, "B");
        }

        if (end.charAt(end.length() - 1) == 'A') {
            end.deleteCharAt(end.length() - 1);
            permutation(start, end);
            end.append('A');
        }
    }
}
