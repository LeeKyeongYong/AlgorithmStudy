package com.algorithm2024.programers02;

public class Example20240429_1 {
    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int remainder = n % 3;
            if (remainder == 0) {
                sb.insert(0, "4");
                n = (n / 3) - 1;
            } else {
                sb.insert(0, remainder);
                n /= 3;
            }
        }

        String result = sb.toString().replaceAll("^0+", "");
        return result.isEmpty() ? "1" : result;
    }
    /*
      public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append((char) ((n % 3 == 0) ? '4' : (n % 3) + '0'));
            n = (n % 3 == 0) ? (n / 3) - 1 : n / 3;
        }

        String result = sb.reverse().toString().replaceAll("^0+(?!$)", "");
        return result.isEmpty() ? "1" : result;
    }

     */
    /*
 public static String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int remainder = n % 3;
            sb.insert(0, remainder == 0 ? "4" : remainder);
            n = (n - 1) / 3;
        }

        return sb.toString();
    }
    */

}
