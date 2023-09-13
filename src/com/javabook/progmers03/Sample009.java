package com.javabook.progmers03;

public class Sample009 {//프로그래머스 A강조하기
	public static void main(String[] args) {
		String myString="abstract algebra";
		Solution009 s= new Solution009();
		String result = s.solution(myString);
		System.out.println("A강조하기: "+result);
	}
}
class Solution009 {
	public String solution(String myString) {
		/*
		 * String answer = myString.toLowerCase().replaceAll("a","A"); 
		 * return answer;
		 */
		return myString.toLowerCase().replaceAll("a","A"); 
    }
}
