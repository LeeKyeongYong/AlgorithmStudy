package com.algorithm2024.letcode6;

import java.util.ArrayList;
import java.util.List;

public class Example20240921_q386 {
    static List<Integer> answer;

    public List<Integer> lexicalOrder(int n) {
        answer = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n);
        }
        return answer;
    }

    static void dfs(int now, int target) {
        if (now > target) {
            return;
        }

        answer.add(now);
        for (int i = 0; i < 10; i++) {
            dfs(now * 10 + i, target);
        }
    }

    public static void main(String[] args) {
        Example20240921_q386 sol = new Example20240921_q386();
        // 1, 10, 11, 12, 13, 2, 3, 4 , ... , 9
        System.out.println(sol.lexicalOrder(13));
    }
}
