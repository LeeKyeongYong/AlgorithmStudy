package com.algorithm2025.backjoon2.day001;

import java.io.*;
public class Example20250303_Q5543 { // 상근날드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int min_f = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min_f = Math.min(min_f, Integer.parseInt(br.readLine()));
        }

        int min_s = Math.min(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));

        bw.write((min_f + min_s - 50) + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
