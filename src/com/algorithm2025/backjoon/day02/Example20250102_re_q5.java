
package com.algorithm2025.backjoon.day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Example20250102_re_q5 { // 2025년 알고리즘 재복습버전 05 A+B -3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            int spaceIndex = line.indexOf(' ');
            int A = Integer.parseInt(line.substring(0, spaceIndex));
            int B = Integer.parseInt(line.substring(spaceIndex + 1));

            sb.append(A + B).append('\n');
        }

        System.out.print(sb);
    }
}