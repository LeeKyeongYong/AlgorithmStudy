package com.jababookbackjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Example20240404_q2493_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] answer = new int[n];

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                stack.push(new int[]{i + 1, num});
                answer[i] = 0;
                continue;
            }

            // 스택이 안 빈 경우
            answer[i] = 0;
            while (!stack.isEmpty()) {
                int[] before = stack.peek();

                if (before[1] <= num) {
                    stack.pop();
                } else {
                    answer[i] = before[0];
                    break;
                }
            }

            stack.push(new int[]{i + 1, num});
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i)
                    .append(" ");
        }

        System.out.println(sb.toString());
    }
}
