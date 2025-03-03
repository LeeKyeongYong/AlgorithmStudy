package com.algorithm2023.javabook.progmers0;

import java.util.Scanner;

public class Sample029 {
	public static void main(String[] args) {
		Solution29 s=new Solution29();
		Scanner sc=new Scanner(System.in);
		System.out.print("���ڿ� �Է�: ");
		String my_String=sc.next();
		System.out.print("���ڿ� �ݺ�Ƚ��: ");
		int n=sc.nextInt();
		String result=s.solution(my_String,n);
		System.out.println("�ݺ��� ���ڿ� ���: "+result);
	}
}
class Solution29 {
    public String solution(String my_string, int n) {
        String answer = "";
        char[] arr=my_string.toCharArray();
        for(int j=0; j<arr.length; j++) {
	        for(int i=0; i<n; i++) {
	        	answer+=arr[j];
	        }
        }
        return answer;
    }
}