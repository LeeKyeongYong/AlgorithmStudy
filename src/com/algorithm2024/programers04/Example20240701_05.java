package com.algorithm2024.programers04;

import java.util.ArrayList;
import java.util.List;

public class Example20240701_05 { //2023 KAKAO BLIND RECRUITMENT 표현 가능한 이진트리

    public boolean dfs(String b, int i, int depth) {
        if (depth == 0) {
            return true;
        } else if (b.charAt(i) == '0') {
            if (b.charAt(i - depth) == '1' || b.charAt(i + depth) == '1') {
                return false;
            }
        }

        boolean left = dfs(b, i - depth, depth / 2);
        boolean right = dfs(b, i + depth, depth / 2);
        return left && right;
    }

    public int[] solution(long[] numbers) {
        List<Integer> answer = new ArrayList<>();
        for (long num : numbers) {
            String b = Long.toBinaryString(num);
            int length = b.length();
            String nodes = Integer.toBinaryString(length + 1);

            if (nodes.indexOf('1', 1) != -1) {
                int dummies = (1 << nodes.length()) - Integer.parseInt(nodes, 2);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < dummies; i++) {
                    sb.append('0');
                }
                sb.append(b);
                b = sb.toString();
            }

            boolean result = dfs(b, b.length() / 2, (b.length() + 1) / 4);
            answer.add(result ? 1 : 0);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

}
