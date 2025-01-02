package com.algorithm2025.backjoon.day03;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Example20250103_re_q1 {  //2025년 알고리즘 재복습버전 01 X보다 작은수
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int X = sc.nextInt();

            IntStream.range(0, N)
                    .map(i -> sc.nextInt())
                    .filter(temp -> temp < X)
                    .forEach(temp -> System.out.print(temp + " "));
            sc.close();
        }
    }
}
