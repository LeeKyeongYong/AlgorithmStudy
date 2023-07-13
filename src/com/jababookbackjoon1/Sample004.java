package com.jababookbackjoon1;

import java.util.Scanner;

public class Sample004 { //백준 11720 숫자의합
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		String s=sc.next();
		int sum=0;
		for(int i=0; i<n; i++) {
			//입력된 문자열 하나하나 더해준다.
			sum+=Character.getNumericValue(s.charAt(i));
		}
		System.out.println(sum);
		sc.close();
	}
}
/*
 
 입력>>
 1
1

출력 >>
1
 
 */
