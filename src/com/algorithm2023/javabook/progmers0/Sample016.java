package com.algorithm2023.javabook.progmers0;

import java.util.Scanner;

public class Sample016 {
	public static void main(String[] args) {
		System.out.println("�������� �����ּ���.");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Solution16 s=new Solution16();
		int result=s.solution(n);
		System.out.println("���ڳ����������ִ� ����?? "+result);
	}
}
class Solution16 {
    public int solution(int n) {
        int answer = 0;
        int pize=6;
        while(pize%n!=0) {
        	pize+=6;
        }
        answer=pize/6;
        return answer;
    }
}