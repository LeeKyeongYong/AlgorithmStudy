package com.algorithm2024.letcode2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Example20240501_1 { //프로그래머스 월간 코드챌린지 시즌 2 110 옮기기
    public String[] solution(String[] s) {
        return Arrays.stream(s)
                .map(this::mv)
                .toArray(String[]::new);
    }
    private String mv(String temp) {
        Deque<Character> deque = new ArrayDeque<>();
        int count = 0;
        for (char c : temp.toCharArray()) {
            deque.addLast(c);
            if (deque.size() >= 3) {
                char first = deque.removeLast();
                char second = deque.removeLast();
                char third = deque.removeLast();
                if (first == '0' && second == '1' && third == '1') {
                    count++;
                } else {
                    deque.addLast(third);
                    deque.addLast(second);
                    deque.addLast(first);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        int offset = sb.toString().lastIndexOf("0") + 1;
        while (count-- > 0) {
            sb.insert(offset, "110");
        }
        return sb.toString();
    }
}
