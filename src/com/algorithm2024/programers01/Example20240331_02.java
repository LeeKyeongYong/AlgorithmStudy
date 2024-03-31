package com.algorithm2024.programers01;

import java.util.HashMap;
import java.util.Map;

public class Example20240331_02 {//Q1
    static int solution(int price, int money, int count) {
        int answer = 0;

        for (int i = 1; i <= count; i++) {
            answer += (price * i);
        }

        return Math.abs(answer - money);
    }

    public static void main(String[] args) {
        // 10
        System.out.println(solution(3, 20, 4));
    }

}
