package com.javabook.progmers0;

import java.util.Scanner;

public class Sample030 {
	public static void main(String[] args) {
		Solution30 s=new Solution30();
		Scanner sc=new Scanner(System.in);
		System.out.println("문자를 입력해주세요..: ");
		String my_String=sc.next();
		System.out.println("삭제해야할 단어..:");
		String letter=sc.next();
		System.out.println("결과: "+s.solution(my_String, letter));;
	}
}
class Solution30 {
    public String solution(String my_string, String letter) {
        String answer = "";
        answer = my_string.replace(letter,"");
        return answer;
    }
}