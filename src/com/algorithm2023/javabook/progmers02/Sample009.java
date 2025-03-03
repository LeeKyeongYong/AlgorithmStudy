package com.algorithm2023.javabook.progmers02;

import java.util.Arrays;

public class Sample009 {
    public static void main(String[] args) {
        Solution09 s = new Solution09();
        String str = "aAb1B2cC34oOp";
        int solution = s.solution(str);
        System.out.println("문자열에 포함된 숫자의 합 (1): " + solution);
    }
}

class Solution09 {
    public int solution(String my_string) {
        int answer = 0;
        int[] array = Arrays.stream(my_string.replaceAll("[A-Z|a-z]", "").split("")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < array.length; i++) {
            answer += array[i];
        }
        return answer;
    }
}
