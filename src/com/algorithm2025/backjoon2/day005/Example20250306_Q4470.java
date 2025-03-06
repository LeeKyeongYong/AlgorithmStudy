package com.algorithm2025.backjoon2.day005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example20250306_Q4470 { // 줄번호
    public static void main(String[] args) throws IOException {
        // BufferedReader로 변경하여 입력 속도 향상
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 출력 결과를 모으기 위한 StringBuilder 사용
        StringBuilder sb = new StringBuilder();

        // 줄 수 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 각 줄에 번호 붙여서 출력
        for (int i = 1; i <= N; i++) {
            String text = br.readLine();
            sb.append(i).append(". ").append(text).append('\n');
        }

        // 모든 결과 한 번에 출력
        System.out.print(sb);

        // 리소스 정리
        br.close();
    }
}