package com.algorithm2023.javabook.progmers0;

import java.util.Scanner;

public class Sample037 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Solution37 s=new Solution37();
		System.out.println("������ �Է����ּ���!! ");
		int n=sc.nextInt();
		System.out.println("�������� �Է����ּ���!!");
		int t=sc.nextInt();
		int result=s.solution(n, t);
		System.out.println("�������� �����: "+result+" ������ ���ĵǾ����ϴ�.");
	}
}
class Solution37 {
    public int solution(int n, int t) {
        int answer = 0;
        int cnt=0;
        if(n>=1&&n<=10&&t>=1&&t<=15) {
	        while(cnt!=t) {
	        	n*=2;
	        	cnt++;
	        }
	        answer=n;
        }
        return answer;
    }
}