package com.algorithm2023.javabook.algoritm1;

import java.util.HashSet;
import java.util.Set;

public class Example20241004_q1 {
    public static int solution(int[][] flowers) {
        Set<Integer> flowerDate = new HashSet<>();
        for (int[] flower : flowers) {
            for (int i = flower[0]; i < flower[1]; i++) {
                flowerDate.add(i);
            }
        }

        return flowerDate.size();
    }

    public static void main(String[] args) {
        // 6
        System.out.println(Example20241004_q1.solution(new int[][]{
                {2, 5},
                {3, 7},
                {10, 11}
        }));

        // 5
        System.out.println(Example20241004_q1.solution(new int[][]{
                {3, 4},
                {4, 5},
                {6, 7},
                {8, 10}
        }));
    }
}
