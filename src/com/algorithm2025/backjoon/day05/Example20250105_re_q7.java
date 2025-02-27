package com.algorithm2025.backjoon.day05;

import java.math.BigInteger;
import java.util.Scanner;

public class Example20250105_re_q7 { // 10757 큰수 A+B
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력을 한번에 처리하고 바로 더한 후 출력
        System.out.println(sc.nextBigInteger().add(sc.nextBigInteger()));
    }
}
