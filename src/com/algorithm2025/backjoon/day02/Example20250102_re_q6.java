package com.algorithm2025.backjoon.day02;

import java.io.*;

public class Example20250102_re_q6 { // 2025년 알고리즘 재복습버전 06 N찍기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            sb.append(i).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
