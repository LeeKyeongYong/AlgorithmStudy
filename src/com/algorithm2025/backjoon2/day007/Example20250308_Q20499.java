package com.algorithm2025.backjoon2.day007;

import java.util.Scanner;

public class Example20250308_Q20499 { // 다리우스님 한타 안함?
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] input = sc.nextLine().split("/");
            int k = Integer.parseInt(input[0]);
            int d = Integer.parseInt(input[1]);
            int a = Integer.parseInt(input[2]);
            System.out.println((d == 0 || k + a < d) ? "hasu" : "gosu");
        }
    }
}
