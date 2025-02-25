package com.algorithm2025.backjoon.day04;

import java.math.BigInteger;
import java.util.Scanner;

public class Example20250104_re_q1 { // 팩토리얼
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // N이 0 이상인 경우에만 계산
        if (N < 0) {
            System.out.println("입력값이 유효하지 않습니다.");
            return;
        }

        // BigInteger를 사용하여 팩토리얼 계산
        BigInteger fac = BigInteger.ONE;
        for (int i = 2; i <= N; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }

        System.out.println(fac);
    }
}
