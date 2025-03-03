package com.algorithm2023.javabook.progmers02;

public class Sample034 {//이진수 덧셈
    public static void main(String[] args) {
        String bin1 = "10";
        String bin2 = "11";
        Solution34 s = new Solution34();
        String result = s.solution(bin1, bin2);
        System.out.println("이진수 덧셈 결과: " + result);
    }
}
class Solution34 {//2진수 덧셈
    public String solution(String bin1, String bin2) {
        String answer = "";
        int numBin1 = Integer.parseInt(bin1, 2);
        int numBin2 = Integer.parseInt(bin2, 2);
        answer = Integer.toBinaryString(numBin1 + numBin2);
        return answer;
    }
}
