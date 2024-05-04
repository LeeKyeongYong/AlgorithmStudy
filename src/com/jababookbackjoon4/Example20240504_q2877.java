package com.jababookbackjoon4;

import java.util.Scanner;

public class Example20240504_q2877 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        /**
         * 4 (0)
         * 7 (1)
         *
         * 44 (00)
         * 47 (01)
         * 74 (10)
         * 77 (11)
         * ~ 6
         *
         * 444 (000)
         * 447 (001)
         * 474
         * 477
         * 744
         * 747
         * 774
         * 777
         */

        k++;
        int num = 0;
        StringBuilder sb = new StringBuilder();

        // k+1 을 2진수 변환
        while (k != 0) {
            num = k % 2;
            sb.append(num);
            k /= 2;
        }

        // 뒤에 하나 빼고 append
        StringBuilder answer = new StringBuilder();
        for (int i = sb.toString().length() - 2; i >= 0; i--) {
            if (sb.charAt(i) == '0') {
                answer.append(4);
            } else {
                answer.append(7);
            }
        }

        System.out.println(answer.toString());
    }
}
