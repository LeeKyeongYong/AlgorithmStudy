package com.algorithm2023.jababookbackjoon;

import java.util.Scanner;

public class Sample039 { //백준 11727 2×n 타일링 2
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int[] dp=new int[1001];
		dp[1]=1;
		dp[2]=3;
		
		for(int i=3; i<=N; i++) {
			dp[i] = (dp[i-1]+2*dp[i-1])%10007;
		}
		
		System.out.println(dp[N]);
	}
}
/*
입력 1>> 
2
출력 1>>
3

입력 2>>
8

출력 2>>
171

입력 3>>
12

출력 3>>
2731
*/