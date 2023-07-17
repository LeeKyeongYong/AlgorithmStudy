package com.javabook.progmers02;

public class Sample007 { // 정수 제곱근 판별
    public static void main(String[] args) {
        Solution007 s = new Solution007();
        int n = 144;
        int solution = s.solution(n);
        System.out.println("정수 제곱근 판별 결과: " + solution);
    }
}

class Solution007 {
    public int solution(int n) {
        int answer = 0;
        answer = 2;
        for (int i = 1; i <= 1000; i++) {
            if (Math.pow(i, 2) == n) {
                answer = 1;
            }
        }
        return answer;
    }
}
