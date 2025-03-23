package com.algorithm2025.backjoon2.day011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example20250322_Q10810 { // 공 넣기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] B = new int[N];

        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            int k = Integer.parseInt(st.nextToken());

            for (int index = i; index <= j; index++) {
                B[index] = k;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int value : B) {
            sb.append(value).append(" ");
        }
        System.out.println(sb);
    }
}
