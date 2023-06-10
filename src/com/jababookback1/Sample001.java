package com.jababookback1;

import java.util.Arrays;
import java.util.Scanner;

public class Sample001 { //백준 16287 Parcel
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int w=sc.nextInt();
		int n=sc.nextInt();
		int[] p=new int[n];
		
		for(int i=0; i<n; i++) {
			p[i]=sc.nextInt();
		}
		
		int[] d=new int[444444];
		int[] d2=new int[444444];
		
		Arrays.fill(d, -1); //초기화 시키기위함 -1은 배열인덱스 숫자를 아직 없음의미
		
		Arrays.fill(d2,-1);
		
		
		for(int i=0; i<n; i++) {
			
			for(int j=i+1; j<n; j++) {
				
				int weight=p[i]+p[j];
				
				if(d[weight]==-1) {
					
					d[weight]=i;
					
					d2[weight]=j;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			
			for(int j=i+1; j<n; j++) {
				
				int weight=w-(p[i]+p[j]);
				
				if(weight>400000||weight<0||d[weight]<0)
					continue;
				
				if(d[weight]!=i&&d2[weight]!=j&&d[weight]!=j&&d2[weight]!=i) {
					
					System.out.println("yes");
					
					return;
				}
			}
		}
		
		System.out.println("No");
		sc.close();
	}
}
/*
 입력 1>>
10 6
5 10 7 3 2 1

출력 1>>
NO

입력 2>>
21 7
10 1 4 6 2 8 5

출력 2>>
 YES
 
 */
