package com.javabook.progmers02;

public class Sample033 {//문자열에 숫자 합계
    public static void main(String[] args) {
        String myString = "aAb1B2cC34oOp";
        Solution33 s = new Solution33();
        int result = s.solution(myString);
        System.out.println("문자열에 숫자 합계: " + result);
    }
}
class Solution33 {
    public int solution(String myString) {
        int answer = 0;
        String[] arr = myString.replaceAll("[^0-9]", " ").split(" ");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("")) {
                continue;
            } else {
                answer += Integer.parseInt(arr[i].trim());
            }
        }

        return answer;
    }
}
