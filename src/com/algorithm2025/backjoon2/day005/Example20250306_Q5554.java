package com.algorithm2025.backjoon2.day005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example20250306_Q5554 { // 심부름가는길
    public static void main(String[] args) throws IOException {
        // Scanner 대신 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalSeconds = 0;

        // 4개의 시간 입력 받기
        for (int i = 0; i < 4; i++) {
            totalSeconds += Integer.parseInt(br.readLine().trim());
        }

        // 결과 계산 및 출력
        StringBuilder sb = new StringBuilder();
        sb.append(totalSeconds / 60).append('\n');
        sb.append(totalSeconds % 60);

        System.out.print(sb);
        br.close();
    }
}