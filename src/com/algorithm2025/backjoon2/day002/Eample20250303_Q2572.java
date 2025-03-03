package com.algorithm2025.backjoon2.day002;

import java.util.Arrays;
import java.util.Scanner;

public class Eample20250303_Q2572 { // 세수정렬
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 세 수를 배열에 입력받기
        int[] A = new int[3];
        for (int i = 0; i < 3; i++) {
            A[i] = sc.nextInt();
        }

        // 배열을 정렬 후 출력
        Arrays.sort(A);
        System.out.println(A[0] + " " + A[1] + " " + A[2]);
    }
}
