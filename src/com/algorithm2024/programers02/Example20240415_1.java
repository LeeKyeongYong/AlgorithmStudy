package com.algorithm2024.programers02;

import java.util.Arrays;

public class Example20240415_1 {//앙궁대회
    static int gap;
    static int[] answer;
    static int[] arr;

    public static int[] solution(int n, int[] info) {
        answer = new int[]{-1};
        gap = 0;
        arr = new int[11];

        permutation(0, n, info);

        if (gap == 0) {
            return new int[]{-1};
        }

        return answer;
    }

    static void permutation(int index, int n, int[] apeachInfo) {
        if (index == n) {
            int rionScore = 0;
            int apeachScore = 0;

            for (int i = 0; i <= 10; i++) {
                if (apeachInfo[i] == 0 && arr[i] == 0) {
                    continue;
                }

                if (apeachInfo[i] < arr[i]) {
                    rionScore += (10 - i);
                } else {
                    apeachScore += (10 - i);
                }
            }

            int diff = rionScore - apeachScore;


            if (diff >= gap) {
                gap = diff;
                answer = arr.clone();
            }

            return;
        }

        for (int i = 0; i <= 10 && arr[i] <= apeachInfo[i]; i++) {
            arr[i]++;
            permutation(index + 1, n, apeachInfo);
            arr[i]--;
        }
    }

    public static void main(String[] args) {
        // [0,2,2,0,1,0,0,0,0,0,0]
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})));

        // 1 1 1 1 1 1 1 1 0 0 2
        System.out.println(Arrays.toString(solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3})));
    }
}
