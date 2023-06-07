package com.jababookbackjoon;

import java.util.Scanner;

public class Sample038 { //14500 백준 테트로미노 
	
	static final int max_int=501;
	static int n,m,result;
	static int[][] a = new int[max_int][max_int];
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static boolean[][] check=new boolean[max_int][max_int];
	
	static int[][]ex = {
			{0,0,0,1},
			{0,1,2,1},
			{0,0,0,-1},
			{0,-1,0,1}
	};
	static int[][]ey = {
			{0,1,2,1},
			{0,0,0,1},
			{0,1,2,1},
			{0,1,1,1}
	};
	
	static int max(int a,int b) {
		return a > b ? a : b;
	}
	
	static void dfs(int x,int y,int sum_value,int length) {
		
		if(length>=4) {
			result=max(result,sum_value);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx<1||nx>n||ny<1||ny>m)
				continue;
			
			if(!check[nx][ny]) {
				check[nx][ny] = true;
				dfs(nx,ny,sum_value+a[ny][ny],length+1);
			}
			
		}
	}
	
	static void checkExShape(int x,int y) {
		for(int i=0; i<4; i++) {
			boolean isOut=false;
			int sum_value=0;
			
			for(int j=0; j<4; j++) {
				int nx=y+ex[i][j];
				int ny=y+ey[i][j];


				if(nx < 1 || nx > n || ny < 1 || ny > m ) {
					isOut=true;
					break;
				} else {
					sum_value+=a[nx][ny];
				}
				
			}
			
			if(!isOut) {
				result=max(result,sum_value);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				a[i][j]=sc.nextInt();
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				check[i][j]=true;
				dfs(i,j,a[i][j],1);
				check[i][j]=false;
				checkExShape(i, j);
			}
		}
		sc.close();
		System.out.println(result);
		
	}
}
/*
입력1>>
5 5
1 2 3 4 5
5 4 3 2 1
2 3 4 5 6
6 5 4 3 2
1 2 1 2 1

출력 1>>
19
*/