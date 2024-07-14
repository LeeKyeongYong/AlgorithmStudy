package com.algorithm2024.programers04;

public class Example20240714_01 { //2018 KAKAO BLIND RECRUITMENT [1차] 다트 게임
    public static int solution(String dartResult) {
        int[] res = new int[3];
        int index = 0;
        dartResult = dartResult.replace("10", "t");
        int cnt = 0; // 한판 점수

        for (int i = 0; i < dartResult.length(); i++) {
            char n = dartResult.charAt(i);

            if (Character.isDigit(n)) {
                cnt += Character.getNumericValue(n);
                continue;
            } else if (n == 't') {
                cnt += 10;
                continue;
            } else if (n == 'S') {
                res[index++] = cnt;
            } else if (n == 'D') {
                res[index++] = cnt * cnt;
            } else if (n == 'T') {
                res[index++] = cnt * cnt * cnt;
            } else if (n == '*') {
                if (index > 1) {
                    res[index - 1] *= 2; // 해당 점수 2배
                    res[index - 2] *= 2; // 바로 전 점수 2배
                } else {
                    res[index - 1] *= 2; // 한판만 했으면
                }
            } else if (n == '#') {
                res[index - 1] *= -1;
            }
            cnt = 0; // 한판 점수 초기화
        }
        return res[0] + res[1] + res[2];
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(solution("1S2D*3T")); // 37
        System.out.println(solution("1D2S#10S")); // 9
        System.out.println(solution("1D2S0T")); // 3
        System.out.println(solution("1S*2T*3S")); // 23
        System.out.println(solution("1D#2S*3S")); // 5
        System.out.println(solution("1T2D3D#")); // -4
        System.out.println(solution("1D2S3T*")); // 59
    }
}
