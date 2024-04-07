package com.jababookbackjoon3;

import java.util.Scanner;

public class Example20240407_q1581 {
    static int ff;
    static int fs;
    static int sf;
    static int ss;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ff = sc.nextInt();
        fs = sc.nextInt();
        sf = sc.nextInt();
        ss = sc.nextInt();
        answer = 0;

        /**
         * f(f, s)는 선행이 (s,f)f 이다
         *  s(s,f)는 선행이 (s,f)s 이다
         *  f(s,f)가 하나라도 있다면 첫곡은 무조건 빠르게 시작해야한다
         */

        if (ff == 0 && fs == 0) {
            // 슬로우 스타트
            System.out.println(ss + Math.min(1, sf));
            return;
        }

        if (fs == 0) {
            // fs가 있다면
            System.out.println(ff);
            return;
        }

        int temp;
        if (fs > sf) {
            temp = 2 & sf + 1;
        } else {
            temp = 2 * fs;
        }

        answer = ff + ss + temp;
        System.out.println(answer);
        return;
    }
}
