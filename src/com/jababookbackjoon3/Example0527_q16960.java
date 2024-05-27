package com.jababookbackjoon3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Example0527_q16960 {
    static int n;
    static int m;
    static List<Integer>[] switches;
    static int[] ramps;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        switches = new List[n + 1];
        ramps = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            switches[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            int count = sc.nextInt();

            for (int j = 0; j < count; j++) {
                int linkedRamp = sc.nextInt();
                switches[i].add(linkedRamp);
                ramps[linkedRamp]++;
            }
        }

        System.out.println(Arrays.toString(ramps));
        for (int i = 1; i <= n; i++) {
            if (isAnswer(i)) {
                System.out.println(1);
                return;
            }
        }


        System.out.println(0);
    }

    static boolean isAnswer(int switchIndex) {
        boolean flag = true;

        for (Integer number : switches[switchIndex]) {
            ramps[number]--;
            if (ramps[number] <= 0) {
                flag = false;
            }
        }

        System.out.println(Arrays.toString(ramps));

        for (Integer number : switches[switchIndex]) {
            ramps[number]++;
        }

        return flag;
    }
}
