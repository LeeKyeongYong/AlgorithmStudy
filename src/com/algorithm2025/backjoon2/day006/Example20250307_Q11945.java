package com.algorithm2025.backjoon2.day006;

import java.util.Scanner;

public class Example20250307_Q11945 { //뜨거운 붕어빵
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // 붕어빵 행과 열 크기 입력
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            // 각 행을 입력받아 뒤집어서 출력
            if(cols>0) {
                for (int i = 0; i < rows; i++) {
                    String line = sc.next();
                    String reversedLine = reverseString(line);
                    System.out.println(reversedLine);
                }
            }
        } finally {
            // 자원 해제
            sc.close();
        }
    }
    private static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}