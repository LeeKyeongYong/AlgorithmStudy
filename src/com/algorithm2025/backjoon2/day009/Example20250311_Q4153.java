package com.algorithm2025.backjoon2.day009;

import java.util.Scanner;
import java.util.Arrays;

public class Example20250311_Q4153 { // 직각삼각형
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            StringBuilder sb = new StringBuilder();

            while (true) {
                int[] sides = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
                if (sides[0] == 0 && sides[1] == 0 && sides[2] == 0) break;

                Arrays.sort(sides); // 정렬하여 가장 긴 변을 마지막 요소로 배치

                sb.append((sides[2] * sides[2] == sides[0] * sides[0] + sides[1] * sides[1])
                        ? "right\n"
                        : "wrong\n");
            }
            System.out.print(sb); // 한 번에 출력하여 성능 향상
        }
    }
}
