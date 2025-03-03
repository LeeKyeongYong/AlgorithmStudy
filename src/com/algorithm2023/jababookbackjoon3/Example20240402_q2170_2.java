package com.algorithm2023.jababookbackjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Example20240402_q2170_2 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            arr[i][0] = Integer.parseInt(str.split(" ")[0]);
            arr[i][1] = Integer.parseInt(str.split(" ")[1]);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }

            return o1[0] - o2[0];
        });

        int answer = arr[0][1] - arr[0][0];
        int beforeStart = arr[0][0];
        int beforeEnd = arr[0][1];

        for (int i = 1; i < n; i++) {
            if (arr[i][0] >= beforeStart && arr[i][1] <= beforeEnd) {
                continue;
            } else if (arr[i][0] < beforeEnd) {
                answer += arr[i][1] - beforeEnd;
            } else {
                answer += arr[i][1] - arr[i][0];
            }

            beforeStart = arr[i][0];
            beforeEnd = arr[i][1];
        }

        System.out.println(answer);
    }
}
