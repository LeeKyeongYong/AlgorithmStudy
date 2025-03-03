package com.algorithm2023.javabook.progmers0;

import java.util.Scanner;

public class Sample011 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("�粿ġ �ֹ�: ");
		int n=sc.nextInt();
		System.out.print("����� ���񽺰���: ");
		int k=sc.nextInt();

		Solution11 s=new Solution11();
		System.out.println("�����ؾ��ϴ� �ݾ�: "+s.solution(n, k));
		sc.close();
	}
}
class Solution11 {
    public int solution(int n, int k) {
        int answer = 0;
        int drink=k*2000;
        int kkochi=n*12000;
        int minus=(n/10)*2000;
        if(n>0&&n<1000) {
        	answer=((drink+kkochi)-minus);
        }
        return answer;
    }
}