package com.jababookbacojoon5;

import java.util.Scanner;

public class Example20240906_q28234 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int speed = 0;
        int total = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (speed < arr[i]) {
                speed += 1;
            } else {
                speed = arr[i];
            }

            total += speed;
        }

        System.out.println(total);
    }
}
