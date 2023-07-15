package com.javabook.progmers02;

public class Sample030 {//k로 나누기
    public static void main(String[] args) {
        int i = 1;
        int j = 13;
        int k = 1;
        Solution30 s = new Solution30();
        int result = s.solution(i, j, k);
        System.out.println("K로 나누기: " + result);
    }
}
class Solution30 {
    public int solution(int i, int j, int k) {
        int answer = 0;

        for(int l = i; l <= j; l++) {
            StringBuilder sb = new StringBuilder();
            sb.append(l);

            int def_length = sb.length();
            for(int a = 0; a < def_length; a++) {
                if((sb.charAt(a) - '0') == k) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
