package com.algorithm2025.backjoon.day01;


import java.util.Scanner;

public class Example20250101_re_q6 { //2025년 알고리즘 재복습버전 06 A/B
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        double A = sc.nextInt();
        double B = sc.nextInt();

        sc.close();

        System.out.println(A/B);

        //float과 dobule의 정밀도 차이도에 대해 고민해보기..
        //float은 6~7자리 double은 16자리정도 ??
        //왠만하면 float보단 dobule을 강추

    }
}

