package com.algorithm2024.letcode;

public class Example20240301_q24 {
    public int characterReplacement(String s, int k) {
        int answer = Integer.MIN_VALUE;

        int[] alphabet = new int[26];
        int l = 0;
        int maxFrequncy = 0;

        for (int r = 0; r < s.length(); r++) {
            int now = s.charAt(r) - 'A';
            alphabet[now]++;

            maxFrequncy = Math.max(maxFrequncy, alphabet[now]);

            int needToChange = (r - l + 1) - maxFrequncy;

            if (needToChange > k) {
                alphabet[s.charAt(l) - 'A']--;
                l++;
            } else {
                answer = Math.max(answer, r - l + 1);
            }
        }

        return answer;
    }
}
