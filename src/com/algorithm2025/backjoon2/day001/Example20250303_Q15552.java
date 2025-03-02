package com.algorithm2025.backjoon2.day001;

import java.io.*;
import java.util.StringTokenizer;

public class Example20250303_Q15552 { // 빠른 A+B
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            bw.write((A + B) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
