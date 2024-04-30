package com.algorithm2024.letcode1;

public class Example20240430_q1143 {
    public int longestCommonSubsequence2(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        text1 = '0' + text1;
        text2 = '0' + text2;

        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }


    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        text1 = "0" + text1;
        text2 = "0" + text2;

        for (int i = 1; i < text1.length(); i++) {
            char t1 = text1.charAt(i);

            for (int j = 1; j < text2.length(); j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (text2.charAt(j) == t1) {
                    dp[i][j]++;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abc", "abc"));
    }
}

