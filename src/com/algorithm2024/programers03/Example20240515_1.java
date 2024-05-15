package com.algorithm2024.programers03;

import java.util.Arrays;
import java.util.Comparator;

public class Example20240515_1 {//프로그래머스 인사고과
    public int solution(int[][] scores) {
        int[] s = scores[0];
        int rank = 1;
        int max1 = 1;
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0])
                    return b[0] - a[0];
                else
                    return a[1] - b[1];
            }
        });
        for (int[] x : scores) {
            if (x[0] > s[0] && x[1] > s[1]) {
                rank = -1;
                break;
            } else if (x[1] >= max1 && (x[0] + x[1]) > (s[0] + s[1])) {
                rank++;
            }
            max1 = Math.max(max1, x[1]);
        }
        return rank;
    }
}
