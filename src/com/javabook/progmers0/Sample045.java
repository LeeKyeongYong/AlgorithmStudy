package com.javabook.progmers0;

public class Sample045 {//문자열에 문자열
	public static void main(String[] args) {
		Solution45 s=new Solution45();
		int result=s.solution("ab6CDE443fgh22iJKlmn1o","6CD");
		System.out.println("문자열에 문자열: "+result);
				
	}
}
class Solution45 {
    public int solution(String str1, String str2) {
        int answer = 0;
        if(str1.contains(str2)) {
        	answer=1;
        }else {
        	answer=2;
        }
        
        return answer;
    }
}