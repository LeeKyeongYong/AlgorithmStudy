package com.algorithm2023.javabook.progmers0;


class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        answer = (num1*1000)/num2;
        return answer;
    }
}

public class Sample001 {
	public static void main(String[] args) {
		Solution s=new Solution();
		System.out.println(s.solution(3, 2));
		System.out.println(s.solution(7, 3));
		System.out.println(s.solution(1, 16));
	}
}
