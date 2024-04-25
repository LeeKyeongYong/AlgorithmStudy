package com.algorithm2024.programers02;

public class Example20240425_02 { //조이스틱
    public static int solution(String name) {
        int moveCount = 0;
        int beforeIndex = 0;
        int count = Integer.MAX_VALUE;

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            if (c == 'A') {
                // 움직일 필요가 없는 경우
                continue;
            }

            // 움직여야하는 경우
            moveCount += getMinMove(c);

            if (i == 0) {
                continue;
            }

            int temp = beforeIndex + name.length() - i;
            count = Math.min(count, Math.min(temp + beforeIndex, temp + name.length() - i));
            beforeIndex = i;
        }

        count = Math.min(count, beforeIndex);

        return moveCount + count;
    }

    static int getMinMove(int c) {
        return Math.min(91 - c, c - 65);
    }

    public static void main(String[] args) {
        // 56
        System.out.println(solution("JEROEN"));

        // 23
        System.out.println(solution("JAN"));
    }
}
