package com.jababookbackjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sample022 { //백준 1074 Z(대문자 제트)
	
	static int n,r,c;
	static int ans;
	
	static void Z(int y,int x,int size) {
	
		if(y==r&&x==c) {
			System.out.println(ans);
			return;
		}
		
		//r,c가 현재 사분면에 존재한다면
		if(r<y+size&&r>=y&&c<x+size&&c>=x) {
			//1사분면 탐색
			Z(y,x,size/2);
			//2사분면 탐색
			Z(y,x+size/2,size/2);
			//3사분면 탐색
			Z(y+size/2,x,size/2);
			//4사분면 탐색
			Z(y+size/2,x+size/2,size/2);
		} else {
			ans+=size*size;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
	
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		
		ans=0;
		Z(0,0,(1<<n));
	}
}
/*
입력>>
2 3 1
*/