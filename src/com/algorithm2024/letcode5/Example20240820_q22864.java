package com.algorithm2024.letcode5;

import java.util.Scanner;

public class Example20240820_q22864 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int consumeEnergy = sc.nextInt(); // 11
        int workEfficient = sc.nextInt(); // 5
        int chargeEnergy = sc.nextInt(); // 1
        int m = sc.nextInt(); // 10

        int time = 24;
        int answer = 0;
        int pirodo = 0;

        while (time-- > 0) {
            if (pirodo + consumeEnergy > m) {
                pirodo -= chargeEnergy;

                if (pirodo < 0) {
                    pirodo = 0;
                }

                continue;
            }

            answer += workEfficient;
            pirodo += consumeEnergy;
        }

        System.out.println(answer);
    }

}
