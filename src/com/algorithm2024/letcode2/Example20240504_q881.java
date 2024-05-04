package com.algorithm2024.letcode2;

import java.util.Arrays;

public class Example20240504_q881 {

    public int numRescueBoats(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }

            right--;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Example20240504_q881 sol = new Example20240504_q881();

        // 4
        System.out.println(sol.numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }
}
