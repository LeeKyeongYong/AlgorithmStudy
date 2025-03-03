package com.algorithm2023.javabook.progmers02;

public class Sample014 { // 문자 위치 바꾸기
    public static void main(String[] args) {
        String my_String = "hello";
        int num1 = 1;
        int num2 = 2;
        Solution14 s = new Solution14();
        String result = s.solution(my_String, num1, num2);
        System.out.println("문자 위치 바꾸기 result: " + result);
    }
}

class Solution14 {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        String[] result = my_string.split(""); // 문자열을 배열로 변환함.
        for (int i = 0; i < result.length; i++) {
            if (i == num1) {
                answer += result[num2];
            } else if (i == num2) {
                answer += result[num1];
            } else {
                answer += result[i];
            }
        }
        return answer;
    }
}
