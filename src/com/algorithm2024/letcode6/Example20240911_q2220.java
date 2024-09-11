package com.algorithm2024.letcode6;

public class Example20240911_q2220 {
    public int minBitFlips(int start, int goal) {
        int answer = 0;
        int xor = start ^ goal;

        while (xor != 0) {
            answer += xor & 1;
            xor >>= 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Example20240911_q2220 sol = new Example20240911_q2220();
        System.out.println(sol.minBitFlips(4, 3));
    }
}
