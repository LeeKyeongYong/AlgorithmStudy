package com.jababookbackjoon3;

import java.util.Arrays;
import java.util.Scanner;

public class Example20240405_q8990 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 마을의 수
        int c = sc.nextInt(); // 박스 용량
        int m = sc.nextInt(); // 보내는 박스 수

        int[][] arr = new int[m][3];
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            arr[i] = new int[]{start, end, value};
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                // 목적지가 같다면 시작지점 오름차순
                return o1[0] - o2[0];
            }

            // 목적지점 오름차순
            return o1[1] - o2[1];
        });

        int[] boxes = new int[n + 1];
        int max = 0;
        int target = 0;
        int total = 0;

        for (int i = 0; i < m; i++) {
            int start = arr[i][0];
            int destination = arr[i][1];
            int value = arr[i][2];
            max = 0;

            // 목적지까지 가면서 실린 박스의 최대 값
            for (int j = start; j < destination; j++) {
                max = Math.max(max, boxes[j]);
            }

            // 박스 용량에서 최대값을 뺀 것과, 현재 박스 용량의 최소값 ==> 실을 수 있는 박스
            target = Math.min(c - max, value);
            total += target;

            for (int j = start; j < destination; j++) {
                boxes[j] += target;
            }
        }

        System.out.println(total + boxes[n]);
    }
}
