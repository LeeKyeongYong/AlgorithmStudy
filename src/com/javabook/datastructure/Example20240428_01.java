package com.javabook.datastructure;

import java.util.Arrays;

public class Example20240428_01 {
    public static int solution2(int[] levels) {
        Arrays.sort(levels);
        int target = (int) Math.ceil((double) (levels.length * 3) / 4);

        if (target >= levels.length) {
            return -1;
        }

        return levels[target];
    }

    public static int solution(int[] levels) {
        int answer = 0;

        int size = levels.length;
        if (size < 4) {
            return -1;
        }

        int cut = (int) Math.floor(size * 0.25);

        for (int i = size - 1; i >= size - cut; i--) {
            answer = levels[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        // 8
        System.out.println(solution2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
