package com.javabook.progmers02;

public class Sample008 {//대문자와 소문자
	public static void main(String[] args) {
		Solution8 s=new Solution8();
		String result="CCCccc";
		String solution=s.solution(result);
		System.out.println("대문자와 소문자 result: "+solution);
	}
}

class Solution8 {
    public String solution(String my_string) {
        String answer = "";
        String[] splitResult=my_string.split("");
        for(int i=0; i<splitResult.length; i++) {
        	if('a'<=splitResult[i].charAt(0)&&splitResult[i].charAt(0)<='z') {
        		answer+=splitResult[i].toUpperCase();
        	} else {
        		answer+=splitResult[i].toLowerCase();
        	}
        }
        return answer;
    }
}