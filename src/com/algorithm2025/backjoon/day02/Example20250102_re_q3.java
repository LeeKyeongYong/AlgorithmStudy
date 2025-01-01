package com.algorithm2025.backjoon.day02;
import java.util.Scanner;

public class Example20250102_re_q3 {
    public static void main(String[] args) { //2025년 알고리즘 재복습버전 03 윤년
        try (var sc = new Scanner(System.in)) {
            if (sc.hasNextInt()) {
                int year = sc.nextInt();
                System.out.println(isLeapYear(year) ? 1 : 0);
            } else {
                System.out.println("잘못된 입력입니다. 정수를 입력해 주세요.");
            }
        }
    }

    private static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
}
