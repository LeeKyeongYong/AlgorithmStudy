package com.javabook.progmers03;

public class Sample008 {//프로그래머스 원하는 문자열 찾기
	public static void main(String[] args) {
		String myString="AbCdEfG";
		String pat="aBc";
		Solution008 s=new Solution008();
		int result = s.solution(myString, pat);
		System.out.println("프로그래머스 원하는 문자열 찾기: "+result);
	}
}

class Solution008 {
    public int solution(String myString, String pat) {
        int answer = 0;
        if(myString.toLowerCase().contains(pat.toLowerCase())){
            answer=1;
        }
        return answer;
    }
}