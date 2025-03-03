package com.algorithm2025.backjoon2.day002;

import java.util.Scanner;

public class Eample20250303_Q3046 { // R2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력을 한 번에 처리하는 방식으로 변경
        int R1 = sc.nextInt();
        int s = sc.nextInt();

        // 필요한 계산을 바로 출력
        System.out.println(2 * s - R1);
    }
}
