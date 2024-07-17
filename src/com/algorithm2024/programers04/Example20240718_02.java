package com.algorithm2024.programers04;

public class Example20240718_02 { // 2018 KAKAO BLIND RECRUITMENT [3차] n진수 게임

    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1)); // "0111"
        System.out.println(solution(16, 16, 2, 1)); // "02468ACE11111111"
        System.out.println(solution(16, 16, 2, 2)); // "13579BDF01234567"
    }

    // n진수로 변환하는 함수
    public static String convert(int number, int base) {
        if (number == 0) return "0";
        StringBuilder result = new StringBuilder();
        String digits = "0123456789ABCDEF";
        while (number > 0) {
            result.append(digits.charAt(number % base));
            number /= base;
        }
        return result.reverse().toString();
    }

    public static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder game = new StringBuilder();
        int cur = p - 1;

        for (int num = 0; game.length() < t * m; num++) {
            game.append(convert(num, n));
        }

        while (answer.length() < t) {
            answer.append(game.charAt(cur));
            cur += m;
        }

        return answer.toString();
    }

}
