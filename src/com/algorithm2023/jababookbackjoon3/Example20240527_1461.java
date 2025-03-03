package com.algorithm2023.jababookbackjoon3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Example20240527_1461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> minus = new ArrayList<>();
        List<Integer> plus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num < 0) {
                minus.add(num);
            } else {
                plus.add(num);
            }
        }

        Collections.sort(minus);
        Collections.sort(plus);
        int answer = 0;

        /**
         * 8 2
         * -39 -37 -29 -28 -6 2 11 50
         */
        // -39 -37 -29 -28 -6 ... 2 11
        boolean isMaximumValueIsInPlus;
        if (minus.isEmpty()) {
            isMaximumValueIsInPlus = true;
        } else if (plus.isEmpty()) {
            isMaximumValueIsInPlus = false;
        } else {
            isMaximumValueIsInPlus = Math.abs(minus.get(0)) < plus.get(plus.size() - 1);
        }

        if (isMaximumValueIsInPlus) {
            // plus가 큰 경우
            // minus부터 해결하기
            for (int i = 0; i < minus.size(); i += m) {
                answer += Math.abs(minus.get(i)) * 2;
            }

            for (int i = plus.size() - 1; i >= 0; i -= m) {
                answer += plus.get(i) * 2;
            }

            answer -= plus.get(plus.size() - 1);
        } else {
            // minus가 큰 경우
            // plus부터 해결하기
            for (int i = plus.size() - 1; i >= 0; i -= m) {
                answer += plus.get(i) * 2;
            }

            for (int i = 0; i < minus.size(); i += m) {
                answer += Math.abs(minus.get(i)) * 2;
            }

            answer -= Math.abs(minus.get(0));
        }

        System.out.println(answer);
    }
}
