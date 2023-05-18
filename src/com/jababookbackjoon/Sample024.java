package com.jababookbackjoon;

import java.util.Scanner;

public class Sample024 { //백준 1003 - 피보나치 함수 _다른버전1
	public static void main(String[] args) {
		int T,N;
		int[] Z = new int[41];
		int[] O = new int[41];
		
		Z[0]=1;
		O[1]=1;
		
		Scanner sc=new Scanner(System.in);
		
		for(int n=2; n<=40; n++) {
			Z[n]=Z[n-1]+Z[n-2];
			O[n]=O[n-1]+O[n-2];
		}
		T = sc.nextInt();
		for(int i=0; i<T; i++) {
			N=sc.nextInt();
			System.out.println(Z[N]+" "+O[N]);
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