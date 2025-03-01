package com.algorithm2025.backjoon.day017;

import java.util.Scanner;

public class Example20250228_q1 { // 27866 문자와 문자열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int index = sc.nextInt();
        System.out.println(text.charAt(index-1));
    }
}
