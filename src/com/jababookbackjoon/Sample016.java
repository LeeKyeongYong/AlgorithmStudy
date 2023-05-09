package com.jababookbackjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Sample016 {//백준 2548 대표 자연수
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int[]num=new int[N];
		
		for(int i=0; i<N; i++) {
			num[i]=sc.nextInt();
		}
		
		//입력받은 숫자들을 정렬
		Arrays.sort(num);
		
		//1. N의 개수가 짝수인경우
		// 중앙값이 2개이므로 더 작은 값을 채택
		
		if(N%2==0) {
			System.out.println(num[N/2-1]);
		} else {
			System.out.println(num[N/2]);
		}
		
		sc.close();
	}
}
/*
입력>>
6
4 3 2 2 9 10
*/