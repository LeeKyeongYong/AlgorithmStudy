package com.algorithm2023.jababookbackjoon;

import java.util.Scanner;

public class Sample040 { //백준 11726 2xn 타일링
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int[] DP=new int[1010];
		DP[1]=1;
		DP[2]=2;
		
		for(int i=3; i<=N; i++) {
			DP[i]=DP[i-1]+DP[i-2];
			DP[i]=DP[i]%1007;
		}
		
		System.out.println(DP[N]);
		
		sc.close();
	}
}
/*
입력>>
2

출력 1>>
2

입력2>>
9

출력2>>

55
*/