package com.algorithm2025.backjoon2.day007;

public class Example20250308_Q13752 { // 히스토그램
    public static void main(String[] args) {
        try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
            int n = sc.nextInt();
            sc.nextLine(); // 개행 문자 소비
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int k = sc.nextInt();
                sc.nextLine(); // 개행 문자 소비
                sb.setLength(0); // StringBuilder 초기화
                for (int j = 0; j < k; j++) {
                    sb.append('=');
                }
                System.out.println(sb);
            }
        }
    }
}
