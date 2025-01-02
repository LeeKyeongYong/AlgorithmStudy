package com.algorithm2025.backjoon.day03;

import java.util.Scanner;

public class Example20250103_re_q2 {  //2025년 알고리즘 재복습버전 02 사분면 고르기
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        sc.close();
        System.out.println((X > 0 ? (Y > 0 ? 1 : 4) : (Y > 0 ? 2 : 3)));
    }
}
