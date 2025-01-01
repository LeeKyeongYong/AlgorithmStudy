package com.algorithm2025.backjoon.day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Example20250102_re_q4 { // 2025년 알고리즘 재복습버전 04 합
    public static void main(String[] args) {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(n * (n + 1) / 2);
        } catch (IOException e) {
            System.out.println("입력 오류 발생: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 정수를 입력해 주세요.");
        }
    }
}
