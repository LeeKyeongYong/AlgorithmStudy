package com.algorithm2025.backjoon2.day006;

import java.util.Scanner;

public class Example20250307_Q11943 { //파일 옮기기
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();

        System.out.println(Math.min((A+D),(C+B)));

    }
}