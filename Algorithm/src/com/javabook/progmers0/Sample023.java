package com.javabook.progmers0;

import java.util.Scanner;

public class Sample023 {
	public static void main(String[] args) {
		Solution23 s=new Solution23();
		Scanner sc=new Scanner(System.in);
		System.out.println("문자열을 입력해주세요!!!");
		String my_String=sc.nextLine();
		String result=s.solution(my_String);
		System.out.println("문자열 뒤집어서 출력: "+result);
	}
}
class Solution23 {
    public String solution(String my_string) {
        String answer = "";
        for(int i=my_string.length()-1; i>=0; i--) {
        	answer+=my_string.substring(i,i+1);
        }
        return answer;
    }
}