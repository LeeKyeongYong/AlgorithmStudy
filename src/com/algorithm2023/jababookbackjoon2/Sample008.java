package com.algorithm2023.jababookbackjoon2;

import java.util.Scanner;

public class Sample008 {
	public static void main(String[] args) { //백준 8393 합
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(); //입력받음
		int sum=0; //받은수만큼 덧셈을 받는 함수
		
		for(int i=0; i<=n; i++) {
			sum+=i; //더한다.입력한 수만큼 카운팅..
		}
		
		sc.close();
		System.out.println(sum);
	}
}
/*
문제 >>
n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.

입력 >>
첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.
3

출력 >>
1부터 n까지 합을 출력한다.
6

*/