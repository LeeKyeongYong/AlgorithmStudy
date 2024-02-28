package com.algorithm2024.letcode;

import java.util.Arrays;

public class Exam20240228_q3 {
    public static int[] solution(int[] targets) {
        int[] people = new int[targets.length];
        int[] choco = new int[targets.length];

        Arrays.fill(choco, 1);

        int[] before = new int[targets.length];

        while (true) {
            int[] temp = new int[targets.length];

            for (int i = 0; i < choco.length; i++) {
                if (choco[i] >= 2) {
                    people[i] += choco[i] - 1;
                    choco[i] = 1;
                }
            }

            for (int i = 0; i < choco.length; i++) {
                if (choco[i] == 1) {
                    temp[targets[i] - 1]++;

                    if (targets[i] - 1 == i) {
                        continue;
                    }

                    choco[i]--;
                }
            }

            choco = temp.clone();

            if (Arrays.equals(choco, before)) {
                break;
            }

            before = choco.clone();

        }

        return people;
    }

    public static void main(String[] args) {
        // 1,0,0,0,0,0
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 5, 6, 4})));

        // 0,0,0,0,4
        System.out.println(Arrays.toString(solution(new int[]{5, 5, 5, 5, 5})));
    }
}
