package com.algorithm2025.backjoon2.day005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example20250306_Q17388 { // 와글와글 숭고한
    public static void main(String[] args) throws IOException {
        // BufferedReader로 변경하여 입력 속도 향상
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 각 대학 점수 입력
        int soongsil = Integer.parseInt(st.nextToken());
        int korea = Integer.parseInt(st.nextToken());
        int hanyang = Integer.parseInt(st.nextToken());

        // 총점 계산
        int totalScore = soongsil + korea + hanyang;

        // 결과 문자열
        String result;

        if (totalScore >= 100) {
            result = "OK";
        } else {
            // 최소값 찾기
            int minScore = Math.min(Math.min(soongsil, korea), hanyang);

            if (minScore == soongsil) {
                result = "Soongsil";
            } else if (minScore == korea) {
                result = "Korea";
            } else {
                result = "Hanyang";
            }
        }

        // 결과 출력
        System.out.println(result);

        // 리소스 정리
        br.close();
    }
}