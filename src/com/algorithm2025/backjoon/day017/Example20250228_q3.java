package com.algorithm2025.backjoon.day017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Example20250228_q3 { // 2738 행렬 덧셈
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        StringBuilder sb = new StringBuilder();

        // 첫 번째 행렬 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 두 번째 행렬 입력 및 연산
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] += Integer.parseInt(st.nextToken());
                sb.append(A[i][j]).append(" ");
            }
            sb.append("\n");
        }

        // 결과 출력
        System.out.print(sb);
    }
}
