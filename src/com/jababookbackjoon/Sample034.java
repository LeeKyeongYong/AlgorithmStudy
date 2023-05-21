package com.jababookbackjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Sample034 {//백준 1006 습격자 초라기
	
	static final int INF=99999999;
	
	static int n,w;
	
	static int[] inner,outer,both;
	
	static int[] inarr,outarr;
	
	static int tmpin,tmpout;
	
	static void clear() {
		
		Arrays.fill(inner,0);
		
		Arrays.fill(outer,0);
		
		Arrays.fill(both,0);
		
	}

	static void fill() {
		
		for(int i=2; i<=n; i++) {
			
			int in2=(inarr[i-1]+inarr[i]<=w)?1:2;
			
			int out2=(outarr[i-1]+outarr[i]<=w)?1:2;
			
			int inout2=(inarr[i]+outarr[i]<=w)?1:2;
			
			inner[i]=Math.min(both[i-1]+1,outer[i-1]+in2);
			
			outer[i]=Math.min(both[i-1]+1,inner[i-1]+out2);
			
			both[i] = Math.min(both[i-1]+inout2,Math.min(both[i-2]+in2+out2,Math.min(inner[i]+1,outer[i]+1)));
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-- > 0) {
			
			int ans=INF;
			
			n = sc.nextInt();
			
			w = sc.nextInt();
			
			inarr = new int[n+1];
			
			outarr = new int[n+1];
			
			inner = new int[n+1];
			
			outer = new int[n+1];
			
			both = new int[n+1];
			
			for(int i = 1; i<=n; i++)
				inarr[i] = sc.nextInt();
			for(int i=1; i<=n; i++)
				outarr[i] = sc.nextInt();
			
			tmpin = inarr[1];
			
			tmpout = outarr[1];
			
			inner[1] = outer[1]=1;
			
			both[1] = (inarr[1]+outarr[1]<=w)?1:2;
			
			fill();
			
			ans = Math.min(ans, both[n]);
			
			clear();
			
			if(n!=1&&inarr[1]+inarr[n]<=w) {
				
				inner[1] = outer[1] = 1;
				
				both[1] = 2;
				
				inarr[1] = INF;
				
				fill();
				
				ans = Math.min(ans, outer[n]);
				
				inarr[1]=tmpin;
				
				clear();
			}
			
			if(n!=1&& outer[1]+outarr[n]<=w) {
				
				inner[1]=outer[1]=1;
				
				both[1]=2;
				
				outarr[1]=INF;
				
				fill();
				
				ans=Math.min(ans, inner[n]);
				
				outarr[1]=tmpout;
				
				clear();
				
			}
			
			if(n!=1&&inarr[1]+inarr[n]<=w&&outer[1]+outarr[n]<=w) {
				
				inner[1]=outer[1]=1;
				
				both[1]=2;
				
				inarr[1]=outarr[1]=INF;
				
				fill();
				
				ans=Math.min(ans, both[n-1]);
				
				inarr[1]=tmpin;
				
				outarr[1]=tmpout;
				
				clear();
			}
			System.out.println(ans);
			
		}
		
		sc.close();
	}
}
/*
입력>>
1
8 100
70 60 55 43 57 60 44 50
58 40 47 90 45 52 80 40
*/