package com.algorithm2025.backjoon2.day009;

import java.util.Scanner;

public class Example20250311_Q1085 { // 직사각형에서 탈출
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            int h = sc.nextInt();
            sc.close();
            int minDistance = Math.min(Math.min(x, w - x), Math.min(y, h - y));
            System.out.println(minDistance);
        }
    }
}
