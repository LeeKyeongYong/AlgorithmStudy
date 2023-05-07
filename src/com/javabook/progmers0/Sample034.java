package com.javabook.progmers0;

import java.util.Scanner;

public class Sample034 {
	public static void main(String[] args) {

		Solution34 s=new Solution34();
		Scanner sc=new Scanner(System.in);
		System.out.println("할머니께 보내는 메세지는?? ");
		String message=sc.next();
		int result=s.solution(message);
		System.out.println("문자열의 최소 가로길이는?? "+result);
	}
}
class Solution34 {
    public int solution(String message) {
        int answer = 0;
        if(message.length()>=1&&message.length()<=50) {
	        char ch[]=message.toCharArray();
	        answer = ch.length*2;
	    }
        return answer;
    }
}