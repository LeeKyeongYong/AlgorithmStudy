package com.algorithm2024.letcode4;

public class Example20240706_q2582 {

    public static int passThePillow(int n, int time) {
        int pos = 1;
        int now = 1;

        while (time-- > 0) {
            if (now == 1) {
                pos = 1;
            } else if (now == n) {
                pos = -1;
            }

            now += pos;
        }

        return now;
    }

    public static void main(String[] args) {
        // 5
        System.out.println(passThePillow(18, 38));
    }

}
