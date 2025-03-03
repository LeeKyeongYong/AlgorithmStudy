package com.algorithm2023.javabook.progmers0;

import java.util.Scanner;

public class Sample032 {
	public static void main(String[] args) {
		//int[] array= {1,1,2,3,4,5};
		int[] array= {0,2,3,4};
		Scanner sc=new Scanner(System.in);
		Solution32 s=new Solution32();
		System.out.println("�ߺ��� ���� �Է����ּ���!!!");
		int n=sc.nextInt();
		int result=s.solution(array,n);
		System.out.println("�ߺ��� ���ڼ��� ������..."+result+" �� �Դϴ�.");
	}
}

class Solution32 {
    public int solution(int[] array, int n) {
        int answer = 0;
        if(array.length>=1&&array.length<=100&&n>=0&&n<=1000) {
	        for(int i=0; i<array.length; i++) {
	        	if(array[i]>=0&&array[i]<=1000) {
		        	if(array[i]==n) {
		        		answer++;
		        	}
	        	}
	        }
        }
        return answer;
    }
}
