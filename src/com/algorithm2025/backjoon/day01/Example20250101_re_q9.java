package com.algorithm2025.backjoon.day01;


import java.util.Scanner;

public class Example20250101_re_q9 { //2025년 알고리즘 재복습버전 09 나머지
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        sc.close();

        System.out.println((A+B)%C);
        System.out.println(((A%C)+(B%C))%C);
        System.out.println((A*B)%C);
        System.out.println(((A%C)*(B%C))%C);


    }
}