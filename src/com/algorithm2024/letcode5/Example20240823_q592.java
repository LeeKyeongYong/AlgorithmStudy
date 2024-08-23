package com.algorithm2024.letcode5;

public class Example20240823_q592 {

    public String fractionAddition(String expression) {
        int upNumber = 0;
        int downNumber = 1;

        int i = 0;
        while (i < expression.length()) {
            int curUpNumber = 0;
            int curDownNumber = 0;
            boolean isNegative = false;

            // 1. 부호처리
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                if (expression.charAt(i) == '-') {
                    isNegative = true;
                }

                // 다음 인덱스
                i++;
            }

            // 2. 분자 숫자 처리
            while (Character.isDigit(expression.charAt(i))) {
                int number = expression.charAt(i) - '0';
                curUpNumber = curUpNumber * 10 + number;
                i++;
            }

            // 2-1. 분자 음수면 음수처리
            if (isNegative) {
                curUpNumber = curUpNumber * -1;
            }

            // 2-2. / 스킵
            i++;

            // 2-3. 분모 처리
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                int number = expression.charAt(i) - '0';
                curDownNumber = curDownNumber * 10 + number;
                i++;
            }

            // 2-4. 분모 분자 계산 (통분)
            upNumber = upNumber * curDownNumber + curUpNumber * downNumber;
            downNumber *= curDownNumber;
        }

        // 약분
        int gcd = Math.abs(getGCD(upNumber, downNumber));
        upNumber /= gcd;
        downNumber /= gcd;

        return upNumber + "/" + downNumber;
    }

    private int getGCD(int a, int b) {
        if (a == 0) {
            return b;
        }

        return getGCD(b % a, a);
    }

    public static void main(String[] args) {
        Example20240823_q592 sol = new Example20240823_q592();

        // 1/3
        System.out.println(sol.fractionAddition("-1/2+1/2+1/3"));
    }

}
