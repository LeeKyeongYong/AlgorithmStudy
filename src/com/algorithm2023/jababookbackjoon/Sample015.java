package com.algorithm2023.jababookbackjoon;

import java.util.Scanner;

public class Sample015 {//백준 10165 격자상의 경로
	public static int f_result(int x,int y,int px,int py) {
		if(x==px&&y==py) {
			return 1;
		}
		if(x>px||y>py) {
			return 0;
		}
		return f_result(x+1,y,px,py)+f_result(x,y+1,px,py);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int k=sc.nextInt();
		if(k==0) {
			System.out.println(f_result(1,1,n,m));
		} else {
			int h=(k-1)/m;
			int w=(k-1)%m;
			System.out.println(f_result(1,1,h+1,w+1)+f_result(h+1,w+1,n,m));
		}
		sc.close();
	}

}
/*
입력>>
3 5 8
*/