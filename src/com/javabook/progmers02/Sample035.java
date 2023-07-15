package com.javabook.progmers02;

public class Sample035 { //다항식 처리
    public static void main(String[] args) {
        //String polynomial = "3x + 7 + x";
        String polynomial = "x + x + x";
        Solution35 s = new Solution35();
        String result = s.solution(polynomial);
        System.out.println("다항식 처리: " + result);
    }
}
class Solution35 {
    public String solution(String polynomial) {
        String answer = "";
        int coefficient = 0; // 계수
        int constantNumber = 0; // 상수
        
        String coefficientStr = ""; // 계수 문자열
        String constantStr = ""; // 상수 문자열
        
        for (String s : polynomial.split(" ")) {
            if (s.contains("x")) {
                coefficient += s.equals("x") ? 1 : Integer.parseInt(s.substring(0, s.length()-1));
            } else if (!s.contains("+")) {
                constantNumber += Integer.parseInt(s);
            }
        }
        
        coefficientStr = coefficient > 0 ? coefficient == 1 ? "x" : coefficient + "x" : "";
        constantStr = constantNumber > 0 ? String.valueOf(constantNumber) : "";
        
        if (coefficient > 0) {
            if (constantNumber > 0) {
                answer += coefficientStr + " + " + constantStr;
            } else {
                answer += coefficientStr;
            }
        } else if (constantNumber > 0) {
            answer += constantStr;
        }
        
        return answer;
    }
}
