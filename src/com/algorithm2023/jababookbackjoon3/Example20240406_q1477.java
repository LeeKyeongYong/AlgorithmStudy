package com.algorithm2023.jababookbackjoon3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Example20240406_q1477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();

        List<Integer> shelter = new ArrayList<>();
        shelter.add(0);
        for (int i = 0; i < n; i++) {
            shelter.add(sc.nextInt());
        }
        shelter.add(l);

        Collections.sort(shelter);

        int left = 1;
        int right = l - 1;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = countShelter(mid, shelter);

            if (count > m) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);

    }

    private static int countShelter(int mid, List<Integer> shelter) {
        int count = 0;

        for (int i = 0; i <= shelter.size() - 2; i++) {
            int temp = shelter.get(i + 1) - shelter.get(i);

            count += (temp) / mid;

            if (temp % mid == 0) {
                count--;
            }
        }

        return count;
    }
}
