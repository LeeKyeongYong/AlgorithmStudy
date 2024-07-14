package com.algorithm2024.letcode4;

public class Example20240714_q1717 {

    public int maximumGain(String s, int x, int y) {
        int countA = 0;
        int countB = 0;
        int sum = 0;

        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
            s = new StringBuilder(s).reverse().toString();
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'a') {
                countA++;
            } else if (c == 'b') {
                // A > 0 경우 CountA--, sum +=
                if (countA > 0) {
                    countA--;
                    sum += x;
                } else {
                    countB++;
                }
            } else {
                sum += Math.min(countB, countA) * y;
                countA = countB = 0;
            }
        }

        sum += Math.min(countB, countA) * y;
        return sum;
    }

}
