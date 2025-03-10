package com.algorithm2025.backjoon2.day008;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Example20250310_Q10818 { // 최소, 최대
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 첫 번째 값으로 min, max 초기화
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (num > max) max = num;
            if (num < min) min = num;
        }

        // StringBuilder 사용하여 빠른 출력
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        System.out.println(sb);
    }
}
