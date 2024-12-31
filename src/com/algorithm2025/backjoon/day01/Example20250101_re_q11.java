package com.algorithm2025.backjoon.day01;


import java.util.Scanner;

public class Example20250101_re_q11 { //2025년 알고리즘 재복습버전 11 별찍기 1
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int star = sc.nextInt();

        sc.close();

        for(int i=1; i<=star; i++){ //N번 반복이 일어나야함

            for(int j= 0; j<i; j++){ // 순차적으로
                System.out.print("*");
            }
            System.out.println();//간격
        }

    }
}