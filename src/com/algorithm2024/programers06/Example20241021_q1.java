package com.algorithm2024.programers06;

import java.util.Arrays;

public class Example20241021_q1 {

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int quantity = 0;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            int lWeight = people[left];
            int rWeight = people[right];

            if (lWeight + rWeight <= limit) {
                left++;
                right--;
                quantity++;
                continue;
            }

            // 보트 무게 초과시
            quantity++;
            right--;
        }

        return quantity;
    }

    public static void main(String[] args) {
        // 3
        // 20, 30, 60, 70, 80
        System.out.println(solution(
                new int[]{20, 60, 70, 80, 30},
                100
        ));

        // 3
        System.out.println(solution(
                new int[]{50, 50, 70, 80},
                100
        ));
    }

}
