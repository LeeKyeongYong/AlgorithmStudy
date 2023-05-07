package com.javabook.progmers02;

public class Sample021 {//한 번만 등장한 문자
	public static void main(String[] args) {
		Solution021 s=new Solution021();
		String result=s.solution("abcbcdc");
		System.out.println("한 번만 등장한 문자: "+result);
	}
}

class Solution021 {
    public String solution(String s) {
        String answer = "";
        int[] strArr=new int[26];
        for(int i=0; i<strArr.length; i++) { //0으로 채워준다.
        	strArr[i]=0;
        }
        
        for(int i=0; i<s.length(); i++) {//반복이 되지 않은 글자를 배열에 저장한다.
        	strArr[s.charAt(i)-97]+=1;
        }
        
        for(int i=0; i<26; i++) {
        	if(strArr[i]==1) { //한번만 등장한 문자를 카운팅해서 조건이 성립하면 반환
        		answer+=(char)(i+97);
        	}
        }
        
        return answer;
    }
}