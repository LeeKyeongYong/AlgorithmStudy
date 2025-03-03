package com.algorithm2023.javabook.progmers02;

public class Sample039 {//세 자리 숫자3
    public static void main(String[] args) {
        int n = 15;
        Solution39 s = new Solution39();
        int result = s.solution(n);
        System.out.println("세 자리 숫자3 개수: " + result);
    }
}
class Solution39 {
    public int solution(int n) {
        int answer = 0;
        answer = n;
        int i = 1;
        while(i <= answer) {
            if((i % 3 == 0) || String.valueOf(i).contains("3")) {
                answer++;
            }
            i++;
        }
        
        return answer;
    }
}