package com.algorithm2025.backjoon2.day005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example20250306_Q5532 { // 방학숙제
    public static void main(String[] args) throws IOException {
        // BufferedReader로 변경하여 입력 속도 향상
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받기
        int L = Integer.parseInt(br.readLine()); // 방학 일수
        int A = Integer.parseInt(br.readLine()); // 국어 페이지 수
        int B = Integer.parseInt(br.readLine()); // 수학 페이지 수
        int C = Integer.parseInt(br.readLine()); // 하루 최대 국어 페이지
        int D = Integer.parseInt(br.readLine()); // 하루 최대 수학 페이지

        // 국어 숙제 완료 일수 계산 - Math.ceil 사용하여 코드 간결화
        int koreanDays = (int) Math.ceil((double) A / C);

        // 수학 숙제 완료 일수 계산
        int mathDays = (int) Math.ceil((double) B / D);

        // 둘 중 더 오래 걸리는 날짜를 방학 일수에서 빼서 놀 수 있는 날짜 계산
        int playDays = L - Math.max(koreanDays, mathDays);

        // 결과 출력
        System.out.println(playDays);

        // 리소스 정리
        br.close();
    }
}