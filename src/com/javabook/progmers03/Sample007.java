package com.javabook.progmers03;

public class Sample007 { //프로그래머스 부분문자열
	public static void main(String[] args) {
		String str1="abc";
		String str2="aabcc";
		Solution007 s=new Solution007();
		int result = s.solution(str1, str2);
		System.out.println("부분 문자열: "+result);
	}
}

class Solution007 {
    public int solution(String str1, String str2) {
    	/*
        int answer = 0;
        if(str2.contains(str1)){
            answer = 1;
        }
        return answer;
        */
    	return str2.contains(str1)? 1:0;
    }
}