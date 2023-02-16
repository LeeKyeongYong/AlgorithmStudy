package com.javabook.progmers02;

public class Sample020 { //나는 영어가 싫어요
	public static void main(String[] args) {
		Solution s =new Solution();
		String numbers="onetwothreefourfivesixseveneightnine";
		long result=s.solution(numbers);
		System.out.println("영어가싫어요 결과값: "+result);
		
	}
}
class Solution {
    public long solution(String numbers) {
        long answer = 0;
        
        numbers=numbers.replace("zero","0");
        numbers=numbers.replace("one","1");
        numbers=numbers.replace("two","2");
        numbers=numbers.replace("three","3");
        numbers=numbers.replace("four","4");
        numbers=numbers.replace("five","5");
        numbers=numbers.replace("six","6");
        numbers=numbers.replace("seven","7");
        numbers=numbers.replace("eight","8");
        numbers=numbers.replace("nine","9");
        
        answer=Long.parseLong(numbers);
        return answer;
    }
}