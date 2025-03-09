package com.algorithm2025.backjoon2.day007;

import java.util.Scanner;

public class Example20250308_Q2525 { // 오븐시계
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(); // 현재 시각의 시(hour)
        int B = sc.nextInt(); // 현재 시각의 분(minute)
        int C = sc.nextInt(); // 요리하는 데 필요한 시간(분)

        // 총 시간을 분 단위로 계산
        int totalMinutes = A * 60 + B + C;

        // 시(hour)와 분(minute)으로 변환
        int hour = (totalMinutes / 60) % 24;
        int minute = totalMinutes % 60;

        System.out.println(hour + " " + minute);
    }
}
