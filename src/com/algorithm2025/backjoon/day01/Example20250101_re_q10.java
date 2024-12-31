package com.algorithm2025.backjoon.day01;


import java.util.Scanner;

public class Example20250101_re_q10 { //2025년 알고리즘 재복습버전 10 두수비교하기
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        sc.close();

        String result = A > B ? ">" : A < B ? "<" : "==";

        System.out.println("결과: "+result);

    }
}