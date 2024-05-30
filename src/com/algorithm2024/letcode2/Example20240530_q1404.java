package com.algorithm2024.letcode2;

public class Example20240530_q1404 {

    public int numSteps(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);

        while (sb.length() > 1) {
            int n = sb.length();

            if (sb.charAt(n - 1) == '0') {
                sb.deleteCharAt(s.length() - 1);
            } else {
                int i = s.length() - 1;

                while (i >= 0 && s.charAt(i) != '0') {
                    sb.setCharAt(i, '0');
                    i--;
                }

                if (i < 0) {
                    sb.insert(0, '1');
                } else {
                    sb.setCharAt(i, '1');
                }
            }

            answer++;
        }

        return answer;
    }

}
