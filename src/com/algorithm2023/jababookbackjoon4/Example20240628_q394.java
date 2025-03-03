package com.algorithm2023.jababookbackjoon4;

import java.util.Stack;

public class Example20240628_q394 {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> makeHistories = new Stack<>();
        StringBuilder nowAlpha = new StringBuilder();
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // 자릿수 계산
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                //  [ ] 안에 숫자 곱해야하므로 지금까지 나온 숫자 일단 push
                countStack.push(count);

                // 현재까지 만든 문자를 일단 Stack에 Push 및 앞으로 나올 거랑 합칠거
                makeHistories.push(nowAlpha);

                // 새로운 [ ] 조합을 위해 초기화
                nowAlpha = new StringBuilder();
                count = 0;
            } else if (ch == ']') {
                StringBuilder madeAlpha = makeHistories.pop();
                int nowCount = countStack.pop();
                madeAlpha.append(String.valueOf(nowAlpha).repeat(Math.max(0, nowCount)));
                nowAlpha = madeAlpha;
            } else {
                nowAlpha.append(ch);
            }
        }

        return nowAlpha.toString();
    }

    public static void main(String[] args) {
        // Output: "accaccacc"
        System.out.println(decodeString("3[a2[c]]"));
    }
}
