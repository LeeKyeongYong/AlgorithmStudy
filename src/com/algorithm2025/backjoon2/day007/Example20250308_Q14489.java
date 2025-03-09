package com.algorithm2025.backjoon2.day007;

import java.util.Scanner;

public class Example20250308_Q14489 { // 치킨 두 마리
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int totalMoney = sc.nextInt() + sc.nextInt();
            int chickenPrice = sc.nextInt() * 2;

            System.out.println(totalMoney >= chickenPrice ? totalMoney - chickenPrice : totalMoney);
        }
    }
}