package com.algorithm2025.backjoon.day04;

import java.util.Scanner;

    public class Example20250104_re_q2 { //1998년생인 내가 태국에서는 2541년생?!
        public static void main(String[] args) {
            try (Scanner sc = new Scanner(System.in)) { // 자동으로 Scanner 닫히도록 try-with-resources 사용
                int y = sc.nextInt();
                if (y < 543) {
                    System.out.println("유효하지 않은 연도입니다.");
                } else {
                    System.out.println(y - 543);
                }
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
