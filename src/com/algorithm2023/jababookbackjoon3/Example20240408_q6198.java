package com.algorithm2023.jababookbackjoon3;

import java.util.Scanner;
import java.util.Stack;

public class Example20240408_q6198 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        long answer = 0;

        for (int i = 0; i < n; i++) {
            int building = sc.nextInt();

            while (!stack.isEmpty() && stack.peek() <= building) {
                stack.pop();
            }

            answer += stack.size();
            stack.push(building);
        }

        System.out.println(answer);
    }
}
