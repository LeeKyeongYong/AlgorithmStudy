package com.algorithm2023.jababookbacojoon5;

import java.util.Scanner;

public class Example20240905_q1459_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long answer = 0;
        long row = sc.nextLong();
        long col = sc.nextLong();
        long cost = sc.nextLong();
        long diaCost = sc.nextLong();

        long case1 = (row + col) * cost;
        long case2 = 0;
        long case3 = (Math.min(row, col)) * diaCost + (Math.abs(row - col)) * cost;

        if ((row + col) % 2 == 0) {
            case2 = Math.max(row, col) * diaCost;
        } else {
            case2 = (Math.max(row, col) - 1) * diaCost + cost;
        }

        System.out.println(Math.min(case1, Math.min(case2, case3)));
    }

}
