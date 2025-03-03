package com.algorithm2023.jababookbackjoon;

import java.util.Scanner;

public class Sample014 { //백준2116 주사위 쌓기
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[]front= {0,6,4,5,2,3,1};
		int[][]dice=new int[n][7];
		int ans=0;
		
		for(int i=0; i<n; i++) {
			for(int j=1; j<=6; j++) {
				dice[i][j]=sc.nextInt();
			}
		}
		for(int i=1; i<=6; i++) {
			int sum=0,maxN=0,idx=0;
			for(int p=1; p<=6; p++) {
				if(p!=dice[0][i]&&p!=dice[0][front[i]]) {
					maxN=Math.max(maxN, p);
				}
			}

			sum+=maxN;
			int std=dice[0][i];
			for(int j=1; j<n; j++) {
				maxN=0;
				for(int x=1; x<=6; x++) {
					if(dice[j][x]==std) {
						idx=x;
						break;
					}
				}
				int top=dice[j][front[idx]];
				int bootom=std;
				for(int k=1; k<=6; k++) {
					if(k!=top&&k!=bootom) {
						maxN=Math.max(maxN, k);
					}
				}
				sum+=maxN;
				std=top;
			}
			ans=Math.max(ans, sum);
		}
		
		System.out.println(ans);
		sc.close();
	}
}
/*
입력>>
5
2 3 1 6 5 4
3 1 2 4 6 5
5 6 4 1 3 2
1 3 6 2 4 5
4 1 6 5 2 3
*/