package com.algorithm2023.jababookbackjoon;

import java.util.Scanner;

public class Sample025 {//백준 1003 - 피보나치 함수 _다른버전2
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T,N;
		int[] F=new int[41];
		F[1]=1;
		
		for(int n=2; n<=40; n++) {
			F[n]=F[n-1]+F[n-2];
		}
		T=sc.nextInt();
		for(int i=0; i<T; i++) {
		
			N=sc.nextInt();
			if(N==0) {
				System.out.println("1 0");
			} else {
				System.out.printf("%d %d\n",F[N-1],F[N]);
			}
			
		}
		
		sc.close();
	}
}
/*
입력>>
3
0
1
3
*/