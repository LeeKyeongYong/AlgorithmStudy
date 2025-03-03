package com.algorithm2023.javabook.progmers02;

public class Sample010 { // 문자열추출
    public static void main(String[] args) {
        Solution10 s = new Solution10();
        String cipher = "dfjardstddetckdaccccdegk";
        int code = 4;
        String solution = s.solution(cipher, code);
        System.out.println("문자열추출 result: " + solution);
    }
}

class Solution10 {
    public String solution(String cipher, int code) {
        String answer = "";
        String[] strSplit = cipher.split("");
        for (int i = 0; i < strSplit.length; i++) {
            if ((i + 1) % code == 0) {
                answer += strSplit[i];
            }
        }
        return answer;
    }
}
