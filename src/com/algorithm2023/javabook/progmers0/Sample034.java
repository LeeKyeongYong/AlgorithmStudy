package com.algorithm2023.javabook.progmers0;

import java.util.Scanner;

public class Sample034 {
	public static void main(String[] args) {

		Solution34 s=new Solution34();
		Scanner sc=new Scanner(System.in);
		System.out.println("�ҸӴϲ� ������ �޼�����?? ");
		String message=sc.next();
		int result=s.solution(message);
		System.out.println("���ڿ��� �ּ� ���α��̴�?? "+result);
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