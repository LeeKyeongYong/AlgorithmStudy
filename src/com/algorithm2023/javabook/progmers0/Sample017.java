package com.algorithm2023.javabook.progmers0;

import java.util.Scanner;

public class Sample017 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("����� ���������ΰ���? ");
		int n=sc.nextInt();
		System.out.println("�������� �ҿ����ΰ���??");
		int slice=sc.nextInt();
		
		Solution17 s=new Solution17();
		int result=s.solution(slice, n);
		System.out.println("�ּ� "+result+" ���� �������ֽ��ϴ�.");
		
	}
}
class Solution17 {
    public int solution(int slice, int n) {
        int answer = 0;
        if(n%slice==0) {
        	answer=n/slice;
        } else {
        	answer=n/slice+1;
        }
        return answer;
    }
}