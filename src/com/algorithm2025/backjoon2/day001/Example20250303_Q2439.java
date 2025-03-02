package com.algorithm2025.backjoon2.day001;

import java.io.*;

public class Example20250303_Q2439 { // 별찍기 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            // 공백 추가
            for (int j = 0; j < N - i; j++) {
                bw.write(" ");
            }
            // 별 추가
            for (int j = 0; j < i; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
