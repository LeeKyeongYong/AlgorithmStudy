package com.algorithm2025.backjoon2.day006;

import java.util.Scanner;

public class Example20250307_Q10768 { // 특별한 날

    private static final int SPECIAL_MONTH = 2;
    private static final int SPECIAL_DAY = 18;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int month = sc.nextInt();
            int day = sc.nextInt();

            // 결과 출력
            System.out.println(determineDate(month, day));
        } finally {
            // 자원 해제
            sc.close();
        }
    }
    private static String determineDate(int month, int day) {
        if (month < SPECIAL_MONTH || (month == SPECIAL_MONTH && day < SPECIAL_DAY)) {
            return "Before";
        } else if (month > SPECIAL_MONTH || (month == SPECIAL_MONTH && day > SPECIAL_DAY)) {
            return "After";
        } else {
            return "Special";
        }
    }
}