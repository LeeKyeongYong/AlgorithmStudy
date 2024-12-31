package com.algorithm2025.backjoon.day01;


import java.util.Scanner;

public class Example20250101_re_q8 { //2025년 알고리즘 재복습버전 08 구구단
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int gugudan = sc.nextInt();
        sc.close();

        for (int i = 1; i <= 9; i++) {
            System.out.printf("2 x %d = %d%n", i, gugudan * i);
        }
    }
}