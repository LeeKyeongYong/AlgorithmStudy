package com.algorithm2025.backjoon.day01;


import java.util.Scanner;

public class Example20250101_re_q7 { //2025년 알고리즘 재복습버전 07 시험성적
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int score = sc.nextInt();
        sc.close();

        String result = switch (score / 10) {
            case 9, 10 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> "F";
        };

        System.out.println("결과: "+result);

    }
}