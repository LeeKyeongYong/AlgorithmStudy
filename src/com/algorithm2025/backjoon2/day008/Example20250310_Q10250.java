package com.algorithm2025.backjoon2.day008;

import java.util.Scanner;

public class Example20250310_Q10250 { // ACM 호텔
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int H = sc.nextInt();
            int N = sc.nextInt();

            int Y = N % H == 0 ? H : N % H; // Y는 층 번호
            int X = (N - 1) / H + 1;        // X는 방 번호

            // X가 1자리인 경우 앞에 0을 붙여서 출력
            System.out.printf("%d%02d\n", Y, X);
        }
    }
}
