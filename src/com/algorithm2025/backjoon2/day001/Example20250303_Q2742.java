package com.algorithm2025.backjoon2.day001;

import java.io.*;

public class Example20250303_Q2742 { // 기찍 N
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = N; i > 0; i--) {
            bw.write(i + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
