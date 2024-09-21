package com.algorithm2024.programers06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Example20240921_no4 { //PCCP 기출문제] 4번 / 수식 복원하기
    // N진법 수를 10진수로 변환하는 함수
    private static int NToTen(int base, String num) {
        int number = 0;
        for (int i = 0; i < num.length(); i++) {
            number += Character.getNumericValue(num.charAt(i)) * Math.pow(base, num.length() - 1 - i);
        }
        return number;
    }

    // 10진수 수를 N진법으로 변환하는 함수
    private static String TenToN(int base, int num) {
        if (num == 0) return "0";
        StringBuilder result = new StringBuilder();

        for (int i = 2; i >= 0; i--) {
            int div = num / (int) Math.pow(base, i);
            if (result.length() > 0 || div != 0) {
                result.append(div);
            }
            num %= (int) Math.pow(base, i);
        }
        return result.toString();
    }

    public static String[] solution(String[] expressions) {
        List<String> answer = new ArrayList<>();
        List<String> hint = new ArrayList<>();
        List<Integer> answerFormat = new ArrayList<>();
        int maxFormat = 0;

        // max_format 구하기 및 힌트가 될 수식들(hint)과 답을 구해야 할 수식들(answer) 분리
        for (String e : expressions) {
            String[] parts = e.split(" ");
            String num1 = parts[0], func = parts[1], num2 = parts[2], ans = parts[4];

            // 주어진 수식에서 최대 숫자를 구함 (진법 결정에 사용)
            maxFormat = Math.max(maxFormat, getMaxDigit(num1));
            maxFormat = Math.max(maxFormat, getMaxDigit(num2));

            if (!ans.equals("X")) { // 답이 주어진 수식 (힌트)
                hint.add(e);
                maxFormat = Math.max(maxFormat, getMaxDigit(ans));
            } else { // 답을 구해야 할 수식
                answer.add(e);
            }
        }

        // 가능한 진법 범위에서 힌트를 사용하여 진법 후보를 찾음
        for (int n = maxFormat + 1; n <= 9; n++) {
            boolean isValid = true;
            for (String h : hint) {
                String[] parts = h.split(" ");
                String num1 = parts[0], func = parts[1], num2 = parts[2], ans = parts[4];
                int num1BaseTen = NToTen(n, num1);
                int num2BaseTen = NToTen(n, num2);
                int ansBaseTen = NToTen(n, ans);

                // 덧셈과 뺄셈 조건 검증
                if (func.equals("+") && (num1BaseTen + num2BaseTen != ansBaseTen)) {
                    isValid = false;
                    break;
                } else if (func.equals("-") && (num1BaseTen - num2BaseTen != ansBaseTen)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                answerFormat.add(n); // 가능한 진법 저장
            }
        }

        // 가능한 진법 후보에서 답을 찾아내기
        String[] resultExpressions = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            String[] parts = answer.get(i).split(" ");
            String num1 = parts[0], func = parts[1], num2 = parts[2];
            Set<String> ansSet = new HashSet<>();

            for (int base : answerFormat) {
                int num1BaseTen = NToTen(base, num1);
                int num2BaseTen = NToTen(base, num2);
                String res;

                if (func.equals("+")) {
                    res = TenToN(base, num1BaseTen + num2BaseTen);
                } else { // func equals "-"
                    res = TenToN(base, num1BaseTen - num2BaseTen);
                }
                ansSet.add(res);
            }

            // 가능한 답이 하나뿐일 때만 확정, 그렇지 않으면 ?
            if (ansSet.size() == 1) {
                resultExpressions[i] = num1 + " " + func + " " + num2 + " = " + ansSet.iterator().next();
            } else {
                resultExpressions[i] = num1 + " " + func + " " + num2 + " = ?";
            }
        }

        return resultExpressions;
    }

    // 숫자 문자열에서 가장 큰 자릿수를 구하는 함수
    private static int getMaxDigit(String num) {
        int maxDigit = 0;
        for (char c : num.toCharArray()) {
            maxDigit = Math.max(maxDigit, Character.getNumericValue(c));
        }
        return maxDigit;
    }
}
