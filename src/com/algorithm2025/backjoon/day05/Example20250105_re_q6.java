package com.algorithm2025.backjoon.day05;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Example20250105_re_q6 { // 5597 과제 안내신분
    public static void main(String[] args) {
        Set<Integer> submitted = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        // 제출한 학생 번호를 기록
        for (int i = 0; i < 28; i++) {
            submitted.add(sc.nextInt());
        }

        // 제출하지 않은 학생 출력
        for (int i = 1; i <= 30; i++) {
            if (!submitted.contains(i)) {
                System.out.println(i);
            }
        }
    }
}
