package com.algorithm2025.backjoon2.day001;

import java.io.*;
import java.util.StringTokenizer;

public class Example20250303_Q2480 { // 주사위 세 개
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int reward;
        if (a == b && b == c) {
            reward = 10000 + a * 1000;
        } else if (a == b || a == c) {
            reward = 1000 + a * 100;
        } else if (b == c) {
            reward = 1000 + b * 100;
        } else {
            reward = Math.max(a, Math.max(b, c)) * 100;
        }

        bw.write(reward + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
