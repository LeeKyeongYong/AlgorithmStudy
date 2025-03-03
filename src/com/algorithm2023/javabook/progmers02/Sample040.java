package com.algorithm2023.javabook.progmers02;

public class Sample040 {// 곱셈과 나눗셈
    public static void main(String[] args) {
        int a = 12;
        int b = 21;
        Solution40 s = new Solution40();
        int result = s.solution(a, b);
        System.out.println("곱셈과 나눗셈 결과: " + result);
    }
}

class Solution40 {
    public int solution(int a, int b) {
        int answer = 0;

        while (b % 2 == 0) {
            b = b / 2;
        }

        while (b % 5 == 0) {
            b = b / 5;
        }

        if ((a / (double) b) % 1 == 0) {
            answer = 1;
        } else {
            answer = 2;
        }

        return answer;
    }
}
