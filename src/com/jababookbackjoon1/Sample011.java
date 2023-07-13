package com.jababookbackjoon1;

import java.util.Scanner;

public class Sample011 { //백준 2798 블랙잭
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		
		int M=sc.nextInt();
		
		int max=0;
		
		int[] num=new int[100];
		
		for(int i=0; i<N; i++) {
			
			num[i]=sc.nextInt();
			
		}
		
		for(int i=0; i<N; i++) {
			
			for(int j=i+1; j<N; j++) {
				
				for(int k=j+1; k<N; k++) {
					
					int sum=num[i]+num[j]+num[k];
					
					if(sum>max&&sum<=M) {
						
						max = sum;
						
					}
				}
			}
			
		}
		
		System.out.println(max);
		sc.close();
	}
}
/*
입력>>
5 21
5 6 7 8 9

출력>>
21

*/