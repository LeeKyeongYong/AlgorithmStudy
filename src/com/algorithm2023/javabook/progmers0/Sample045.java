package com.algorithm2023.javabook.progmers0;

public class Sample045 {//���ڿ��� ���ڿ�
	public static void main(String[] args) {
		Solution45 s=new Solution45();
		int result=s.solution("ab6CDE443fgh22iJKlmn1o","6CD");
		System.out.println("���ڿ��� ���ڿ�: "+result);
				
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